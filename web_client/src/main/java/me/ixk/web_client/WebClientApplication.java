package me.ixk.web_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@Configuration
public class WebClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebClientApplication.class, args);
  }

  @Bean
  public WebClient webClient(WebClient.Builder builder) {
    return builder.baseUrl("http://localhost:8080").build();
  }
}
