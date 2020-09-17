package com.mod.application.service;

import org.springframework.stereotype.Service;

import com.mod.application.model.User;
@Service
public interface UserService {
	public User saveUser(User user);
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	public User findByUsernameAndRole(String username,String role);

}
