package me.ixk.json_inject.config;

import java.util.List;
import me.ixk.json_inject.injector.JsonArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Autowired
  ConversionService conversionService;

  @Override
  public void addArgumentResolvers(
    List<HandlerMethodArgumentResolver> resolvers
  ) {
    resolvers.add(new JsonArgumentResolver(conversionService));
  }
}
