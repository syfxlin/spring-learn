package me.ixk.container;

import me.ixk.container.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContainerApplication.class, args);
    }

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/hello")
    public String hello() {
        return applicationContext.getBean("hello")
                + " "
                // 可以通过别名获取，同时也可以设置返回的类型
                + applicationContext.getBean("helloBean", String.class);
        // Hello World! Hello World! (name)
    }

    @GetMapping("/scope")
    public String scope() {
        // user1 的 bean 在启动时就创建完毕了
        User user1 = applicationContext.getBean("user1", User.class);
        User user2 = applicationContext.getBean("user1", User.class);

        // 在控制台会打印两个创建了 User 对象
        User user3 = applicationContext.getBean("user2", User.class);
        User user4 = applicationContext.getBean("user2", User.class);

        // 加了 Lazy 注解会在使用的时候才创建对象
        User user5 = applicationContext.getBean("user3", User.class);

        return (user1 == user2) + " " + (user3 == user4) + " " + user5.getUsername();
        // true false
    }
}
