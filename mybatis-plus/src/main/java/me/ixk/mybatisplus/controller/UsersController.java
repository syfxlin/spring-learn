package me.ixk.mybatisplus.controller;


import me.ixk.mybatisplus.entity.Users;
import me.ixk.mybatisplus.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author syfxlin
 * @since 2020-04-14
 */
@RestController
public class UsersController {
    @Autowired
    public UsersServiceImpl usersService;

    @GetMapping("index")
    public Users index(int id) {
        return usersService.query().eq("id", id).one();
    }
}

