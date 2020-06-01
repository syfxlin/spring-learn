package me.ixk.container.beans;

import me.ixk.container.condition.FalseCondition;
import me.ixk.container.condition.TrueCondition;
import me.ixk.container.entry.User;
import org.springframework.context.annotation.*;

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

    // 默认单例加载方式
    @Bean
    // @Scope
    public User user1() {
        return new User("syfxlin", "12346");
    }

    // 多实例加载方式，Bean默认是单例加载的方式
    @Bean
    @Scope("prototype")
    public User user2() {
        return new User("syfxlin", "123456");
    }

    // 懒加载
    @Bean
    @Lazy
    public User user3() {
        return new User("syfxlin", "123456");
    }

    // 通过 Condition 的返回值判断是否加载
    @Conditional({TrueCondition.class})
    @Bean("condition")
    public String cond1() {
        return "cond1";
    }

    @Conditional({FalseCondition.class})
    @Bean("condition")
    public String cond2() {
        return "cond2";
    }
}
