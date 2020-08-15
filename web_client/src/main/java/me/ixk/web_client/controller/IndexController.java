package me.ixk.web_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class IndexController {

  @GetMapping("/index/{id}")
  public Mono<String> index(@PathVariable String id) {
    return Mono.just(id);
  }
}
