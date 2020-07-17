package me.ixk.laravel_mix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class LaravelMixApplication {

  public static void main(String[] args) {
    SpringApplication.run(LaravelMixApplication.class, args);
  }

  @GetMapping
  public String index() {
    return "index";
  }
}
