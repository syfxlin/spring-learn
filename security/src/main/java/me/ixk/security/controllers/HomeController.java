package me.ixk.security.controllers;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // 由于 WebSecurityConfig 中已经允许所有访问了，这里可以不加这个注解
    @PreAuthorize("permitAll()")
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // 允许指定用户访问
    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    // 禁止所有访问
    @PreAuthorize("denyAll()")
    @GetMapping("/deny")
    public String deny() {
        return "deny";
    }

    // PostAuthorize 会进入该方法执行，但是无法取得响应
    @PostAuthorize("denyAll()")
    @GetMapping("/post")
    public String post() {
        System.out.println("post");
        return "post";
    }
}
