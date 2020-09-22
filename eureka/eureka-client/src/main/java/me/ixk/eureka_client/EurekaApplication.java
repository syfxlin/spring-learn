package me.ixk.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EurekaApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }

  @GetMapping
  public String index() {
    return "index";
  }
}
