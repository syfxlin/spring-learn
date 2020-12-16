package com.sm.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sm.dao.entity.User;

public interface IUserMapper {
	
	//查找所有用户，无参

	public List<User> getAllUser();

	//根据用户名查找 （只有一个参数），应用于用户注册时的用户名查重

	public User getUserByUsername(String un);
	
	//根据用户名及密码查找（包含多个参数的查询，必须使用@param注解参数），应用于用户根据用户名及密码的登录

	public User getUserByUsernameAndPassword(@Param("un")String un,@Param("pwd")String pwd);

	//----------------------------------------
	
	//下面的增加——删除——修改，均不需要注解参数
	
	
	//关键字ignore：忽略主键重复
	public int addUser(User user);
	
	//根据用户名删除用户
	public int deleteUser(String username);

	//根据用户名修改真实姓名
	public int updateUser(User user);

}

