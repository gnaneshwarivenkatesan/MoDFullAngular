package com.mod.application.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mod.application.model.Course;
import com.mod.application.model.User;
import com.mod.application.service.CourseService;
import com.mod.application.service.UserService;

@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserService userService;
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "add/user", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User user1 = new User();
		User user2 = new User();
		String username = user.getUsername();
		String email=user.getEmail();
		user1 = userService.findByUsername(username);
		user2 =userService.findByEmail(email);
		if (user1 != null ) {
			user1.setUsername(null);
			user1.setEmail(null);
			return new ResponseEntity<User>(user1, HttpStatus.OK);
		}
		if(user2!=null)
		{
			user2.setUsername(null);
			user2.setEmail(null);
			return new ResponseEntity<User>(user2, HttpStatus.OK);
		}
		
		else {
			user1 = userService.saveUser(user);
			return new ResponseEntity<User>(user1, HttpStatus.OK);
		}
	}
	@RequestMapping(value = "search/user", method = RequestMethod.GET)
	public ResponseEntity<User> searchUser(@RequestParam String username,@RequestParam String role)
	{
		User user=new User();
		user=userService.findByUsernameAndRole(username, role);
		if(user==null)
		{
			User user1=new User();
			user1.setRole(null);
			user1.setUserfullname(null);
			user1.setEmail(null);
			user1.setUsername(null);
			user1.setStatus("inactive");
			
			return new ResponseEntity<User>(user1,HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
	}

	@RequestMapping(value = "block/user", method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<User> disableUser(@RequestParam String username,@RequestParam String role) {
		User user = new User();
		user = userService.findByUsernameAndRole(username, role);
		if (user == null) {
			User user1=new User();
			user1.setRole(null);
			user1.setUserfullname(null);
			user1.setEmail(null);
			user1.setUsername(null);
			user1.setStatus("inactive");
			
			return new ResponseEntity<User>(user1,HttpStatus.OK);
		} else if (user.getStatus().equals("inactive")) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		} else {
			user.setStatus("inactive");
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "unblock/user", method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<String> enableUser(@RequestParam String username) {
		User user = new User();
		//String email=user.getEmail();
		user = userService.findByUsername(username);
		if (user == null) {
			return new ResponseEntity<String>("User not found", HttpStatus.BAD_REQUEST);
		} else if (user.getStatus().equals("inactive")) {
			return new ResponseEntity<String>("User is not disabled", HttpStatus.BAD_REQUEST);
		} else {
			user.setStatus("active");
			return new ResponseEntity<String>("User has been enabled", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "add/course", method = RequestMethod.POST)
	public ResponseEntity<Course> registerCourse(@RequestBody Course course) {
		Course course1 = new Course();
		String coursename = course.getCoursename();
		course1 = courseService.findByCoursename(coursename);
		if (course1 != null) {
			course1.setCoursename(null);
			return new ResponseEntity<Course>(course1, HttpStatus.OK);
		} else {
			course1 = courseService.saveCourse(course);
			return new ResponseEntity<Course>(course1, HttpStatus.OK);
		}
	}
	@RequestMapping(value = "search/course", method = RequestMethod.GET)
	public ResponseEntity<Course> searchCourse(@RequestParam String coursename)
	{
		Course course=new Course();
		course=courseService.findByCoursename(coursename);
		if(course==null)
		{
			Course course1=new Course();
			course1.setCoursename(null);
			course1.setCourseDescription(null);
			course1.setCourseStatus(null);
			return new ResponseEntity<Course>(course1,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Course>(course,HttpStatus.OK);
		}
		
	}
	@RequestMapping(value = "block/course", method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<Course> disableCourse(@RequestParam String coursename)
	{
		Course course=new Course();
		course=courseService.findByCoursename(coursename);
		if(course==null)
		{
			Course course1=new Course();
			course1.setCoursename(null);
			course1.setCourseDescription(null);
			course1.setCourseStatus(null);
			return new ResponseEntity<Course>(course1,HttpStatus.OK);
		}
		else
		{
			course.setCourseStatus("inactive");
			return new ResponseEntity<Course>(course,HttpStatus.OK);
		}
		
	}

}
