package me.ixk.exception;

import me.ixk.exception.exceptions.IdNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class, args);
    }

    @GetMapping("/index")
    public String index(String id) {
        if (id == null) {
            throw new IdNotFoundException();
        }
        return "id: " + id;
    }
}
