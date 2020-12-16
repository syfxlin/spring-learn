package com.sm.service;
/*
 * 服务层的实现类，调用DAO层
 * 实现类类名可以任意（组件扫描只要求能扫描到服务接口的实现类）
 * @Repository常用于DAO层注解
 * @Service常用于注解服务层
 * @Controller常用于控制器组件注解
 * @Component是组件的通用注解方式
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.entity.User;
import com.sm.dao.mapper.IUserMapper;

 //服务接口实现类注解
public class UserServiceImp implements UserService {
	
	 
	private IUserMapper userDao;  //注入DAO层接口，即映射接口

	 
	public User queryUserByUserNameAndPassword(String username, String password) {
		return userDao.getUserByUsernameAndPassword(username, password);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	@Override
	public void deleteUser(User user) {
		//userDao.deleteUser(user);
		userDao.deleteUser(user.getUsername());
	}

	@Override
	public User queryUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
}
