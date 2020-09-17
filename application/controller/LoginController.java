package com.mod.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mod.application.model.User;
import com.mod.application.service.UserService;
@CrossOrigin(origins="http://localhost:4200") 
@RestController
@RequestMapping("/user")
public class LoginController {
	@Autowired
	UserService userService;
	@RequestMapping(value = "loginr", method = RequestMethod.GET)
	public ResponseEntity<User> loginUser(@RequestParam String username,@RequestParam String role)
	{
		System.out.println(" in user login controller");
		User user=new User();
		user=userService.findByUsernameAndRole(username, role);
		System.out.println("in user login controller,returned value is "+user);
		User user1=new User();
		if(user== null)
		{
			
			user1.setRole(null);
			user1.setUserfullname(null);
			user1.setEmail(null);
			user1.setUsername(null);
			user1.setStatus(null);
			
			//user1.setFullname(null);
			
			
			//user1.setStatus(false);
			return new ResponseEntity<User>(user1,HttpStatus.OK);
		}
		else if(user.getStatus().equals("inactive"))
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		
		
	}

}
