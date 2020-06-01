package me.ixk.filter_interceptor;

import me.ixk.filter_interceptor.annotation.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FilterInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterInterceptorApplication.class, args);
    }

    @Log
    @GetMapping("/index")
    public String index() {
        return "Index";
    }
}
