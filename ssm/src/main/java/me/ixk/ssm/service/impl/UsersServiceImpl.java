/*
 * Copyright (c) 2020, Otstar Lin (syfxlin@gmail.com). All Rights Reserved.
 */

package me.ixk.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.ixk.ssm.entity.Users;
import me.ixk.ssm.mapper.UsersMapper;
import me.ixk.ssm.service.IUsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements
    IUsersService {}
