package me.ixk.ssm.controllers;

import me.ixk.ssm.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UsersServiceImpl usersService;

    @GetMapping("/index")
    public String index(){
        usersService.saveOrUpdate(usersService.list().get(0));
        return "index1";
    }
}
