package me.ixk.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@SpringBootApplication
@EnableRedisRepositories
@Configuration
public class ReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }

    @Bean
    ReactiveRedisTemplate<Object, Object> reactiveRedisTemplate(
        ReactiveRedisConnectionFactory factory
    ) {
        return new ReactiveRedisTemplate<>(
            factory,
            RedisSerializationContext.java()
        );
    }
}
