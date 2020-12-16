package me.ixk.thymeleaf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import me.ixk.thymeleaf.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.LazyContextVariable;

@SpringBootApplication
@Controller
@Slf4j
public class ThymeleafApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThymeleafApplication.class, args);
  }

  @GetMapping("/view")
  public String view(Model model) {
    model.addAttribute("title", "Example");
    List<User> users = new ArrayList<>();
    users.add(new User("name1", 1));
    users.add(new User("name2", 2));
    users.add(new User("name3", 3));
    users.add(new User("name4", 4));
    users.add(new User("name5", 5));
    model.addAttribute("users", users);
    model.addAttribute("user", users.get(0));
    model.addAttribute("userMap", Map.of("name1", users.get(0)));
    model.addAttribute("lazy", new LazyContextVariable<>() {
      @Override
      protected Object loadValue() {
        log.info("Load value");
        return "lazy value";
      }
    });
    return "example";
  }
}
