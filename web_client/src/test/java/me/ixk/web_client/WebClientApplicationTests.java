package me.ixk.web_client;

import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Schedulers;

@SpringBootTest
@Slf4j
class WebClientApplicationTests {
  @Autowired
  WebClient webClient;

  @Test
  void webClient() {
    CountDownLatch count = new CountDownLatch(1);
    webClient
      .get()
      .uri("/index/1")
      .retrieve()
      .bodyToMono(String.class)
      .doOnSuccess(
        res -> {
          log.info("Result: {}", res);
        }
      )
      .doOnError(
        err -> {
          log.error("Error:", err);
        }
      )
      .doFinally(
        s -> {
          count.countDown();
        }
      )
      .subscribeOn(Schedulers.single())
      .subscribe();
    log.info("Waiting");
    try {
      count.await();
    } catch (InterruptedException e) {
      log.error("Await Error", e);
    }
    log.info("Complete");
  }
}
