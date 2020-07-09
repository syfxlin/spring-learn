package me.ixk.validator;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@RestController
public class ValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorApplication.class, args);
    }

    @GetMapping("/user")
    public User user(@Valid User user) {
        return user;
    }

    @GetMapping("/user-result")
    public Map<String, String> userResult(
            @Valid User user,
            BindingResult bindingResult
    ) {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return map;
    }

    @Data
    public static class User {
        @NotNull
        @Size(min = 1, max = 50)
        private String username;

        @NotNull
        @Size(min = 1, max = 50)
        private String password;

        @NotNull
        @Email
        private String email;
    }
}
