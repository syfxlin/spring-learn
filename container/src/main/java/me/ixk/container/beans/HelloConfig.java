package me.ixk.container.beans;

import me.ixk.container.entry.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloConfig {

    @Bean
    public String hello() {
        return "Hello World!";
    }

    // 可以设置别名
    @Bean("helloBean")
    public String helloName() {
        return "Hello World! (name)";
    }

    @Bean
    // @Scope
    public User user1() {
        return new User("syfxlin", "12346");
    }

    @Bean
    @Scope("prototype")
    public User user2() {
        return new User("syfxlin", "123456");
    }

    @Bean
    @Lazy
    public User user3() {
        return new User("syfxlin", "123456");
    }
}
