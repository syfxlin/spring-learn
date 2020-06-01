package me.ixk.thymeleaf;

import java.util.ArrayList;
import java.util.List;
import me.ixk.thymeleaf.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
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
    return "example";
  }
}
