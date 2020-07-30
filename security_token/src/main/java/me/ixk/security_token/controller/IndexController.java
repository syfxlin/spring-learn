package me.ixk.security_token.controller;

import java.util.Map;
import me.ixk.security_token.utils.Jwt;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/token")
    public String getToken() {
        return new Jwt("key", "HS256")
        .encode(Map.of("logged", "syfxlin"), 60000);
    }

    @PostMapping("/index")
    @PreAuthorize("isAuthenticated()")
    public String index() {
        return "index";
    }
}
