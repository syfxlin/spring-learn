package me.ixk.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket buildDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(this.buildApiInf())
      .select()
      .apis(RequestHandlerSelectors.basePackage("me.ixk.swagger.controllers"))
      .paths(PathSelectors.any())
      .build();
  }

  private ApiInfo buildApiInf() {
    return new ApiInfoBuilder()
      .title("RESTful API文档")
      .contact(new Contact("Otstar Lin", "https://ixk.me", "syfxlin@gmail.com"))
      .version("1.0")
      .build();
  }
}
