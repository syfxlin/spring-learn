package me.ixk.redis;

import lombok.extern.slf4j.Slf4j;
import me.ixk.redis.model.User;
import me.ixk.redis.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class RedisApplicationTests {
    @Autowired
    RedisTemplate<String, User> redisTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    void insertAndFind() {
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
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put("users", "syfxlin", user);
        redisTemplate.expire("users", 1, TimeUnit.MINUTES);
        log.info("users {}", hash.get("users", "syfxlin"));

        userRepository.save(user);
        User findUser = userRepository.findTopByUsername("syfxlin");
        log.info("Find by repository {}", findUser);
    }
}
