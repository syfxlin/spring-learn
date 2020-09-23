package me.ixk.eureka_caller;

import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
@Slf4j
class EurekaCallerApplicationTests {
  @Autowired
  RestTemplate restTemplate;

  @Test
  void getFromEurekaClient() {
    final URI uri = UriComponentsBuilder
      .fromUriString("http://eureka-client/")
      .build()
      .toUri();
    log.info(
      "Get from eureka-client: {}",
      restTemplate.getForObject(uri, String.class)
    );
  }
}
