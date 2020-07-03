package me.ixk.freemarker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class FreemarkerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FreemarkerApplication.class, args);
  }

  @GetMapping("/index")
  public String index() {
    return "index1";
  }
}
