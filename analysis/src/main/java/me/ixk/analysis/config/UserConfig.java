package me.ixk.analysis.config;

import me.ixk.analysis.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    User user() {
        return new User("syfxlin");
    }
}
