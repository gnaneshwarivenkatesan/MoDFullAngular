package com.mod.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mod.application.dao.UserDao;
import com.mod.application.model.User;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userdao;

	@Override
	public User saveUser(User user) {
		return userdao.save(user);
	}

	
	@Override
	public User findByUsernameAndRole(String username, String role) {
		return userdao.findByUsernameAndRole(username, role);
	}


	@Override
	public User findByUsername(String username) {
		
		return userdao.findByUsername(username);
	}


	@Override
	public User findByEmail(String email) {
		
		return userdao.findByEmail(email);
	}

}
