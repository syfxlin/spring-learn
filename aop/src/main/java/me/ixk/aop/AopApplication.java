package me.ixk.aop;

import me.ixk.aop.annotation.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @GetMapping("index")
    @Log
    public boolean index() throws Exception {
        System.out.println("Index");
        return true;
    }
}
