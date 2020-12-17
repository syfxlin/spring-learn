package me.ixk.freemarker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.ixk.freemarker.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class FreemarkerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FreemarkerApplication.class, args);
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
    model.addAttribute("nullValue", null);
    return "example";
  }
}
