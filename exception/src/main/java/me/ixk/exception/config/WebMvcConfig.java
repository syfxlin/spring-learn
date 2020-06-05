package me.ixk.exception.config;

import me.ixk.exception.handler.GlobalNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        // 增加全局异常处理器
        resolvers.add(0, new GlobalNotFoundException());
    }
}
