package me.ixk.ssm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/index")
    public String index(){
        return "index1";
    }
}
