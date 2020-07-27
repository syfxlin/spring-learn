package me.ixk.reactive;

import lombok.extern.slf4j.Slf4j;
import me.ixk.reactive.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
@Slf4j
class ReactiveApplicationTests {
    @Autowired
    ReactiveRedisTemplate<Object, Object> redisTemplate;

    @Test
    void insertAndFind() {
        ReactiveHashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        User user = User
            .builder()
            .username("syfxlin")
            .nickname("Otstar Lin")
            .email("syfxlin@gmail.com")
            .password("123456")
            .rememberToken("123")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .url("https://ixk.me")
            .status(1)
            .type("open")
            .emailVerifiedAt(LocalDateTime.now())
            .build();

        Flux
            .fromIterable(List.of(user))
            .publishOn(Schedulers.single())
            .doOnComplete(() -> log.info("User data complete"))
            .flatMap(
                userItem -> {
                    log.info("Put user {}", userItem);
                    return hash.put("users", userItem.getUsername(), userItem);
                }
            )
            .doOnComplete(() -> log.info("Put to redis complete"))
            .concatWith(redisTemplate.expire("users", Duration.ofMinutes(1L)))
            .doOnComplete(() -> log.info("Set expire complete"))
            .onErrorResume(
                e -> {
                    log.error("Resume", e);
                    return Mono.just(false);
                }
            )
            .subscribe(
                bool -> log.info("Success {}", bool),
                err -> log.error("Error", err),
                countDownLatch::countDown
            );
        log.info("Waiting");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("Await Error", e);
        }
        log.info("Complete");
    }
}
