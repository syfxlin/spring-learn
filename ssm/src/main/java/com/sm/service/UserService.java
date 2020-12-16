package com.sm.service;
import java.util.List;

import com.sm.dao.entity.User;

public interface UserService {
	
	public User queryUserByUsername(String username);

	public User queryUserByUserNameAndPassword(String username, String password);
	
	public void addUser(User user);
	
	public void deleteUser(User user);
	
	public List<User> getAllUser();
	
	public void updateUser(User user);





}