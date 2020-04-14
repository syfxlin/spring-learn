package me.ixk.mybatisplus.service.impl;

import me.ixk.mybatisplus.entity.Users;
import me.ixk.mybatisplus.mapper.UsersMapper;
import me.ixk.mybatisplus.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author syfxlin
 * @since 2020-04-14
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
