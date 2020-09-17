package com.mod.application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mod.application.dao.TrainingsDao;
import com.mod.application.dao.UserDao;
import com.mod.application.model.Trainings;
import com.mod.application.model.User;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminReportController {
	public AdminReportController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	UserDao userdao;
	
	@Autowired
	TrainingsDao trainingdao;
	

	
	@GetMapping("/{role}")
	public List<User> getAllUserByRole(@PathVariable String role) {
		//String role="learner";
		System.out.println("role is"+ role);
		System.out.println("In Role(learners and mentor) mapping..");
		List<User> obj=userdao.getByRole(role);
		System.out.println(obj);
		return (List<User>) userdao.getByRole(role);
	}
	
	@GetMapping("/{role}/{status}")
	public List<User> getUserByRoleandStatus(@PathVariable String role,@PathVariable String status) {
		//String role="learner";
		System.out.println("status is "+ status);
		System.out.println("role is "+ role);
		System.out.println("In Role n Status (learners and mentor) ,active and Inactive mapping....");
		
		return (List<User>) userdao.getByRoleAndStatus(status,role);
	
	}
	
	
	@GetMapping("/allCourse")
	public List<Trainings> getCourseDeatils() {
		System.out.println("In Course deatils..");
		return (List<Trainings>) trainingdao.findAll();
	}
	
	@GetMapping("/allCourse/{courseStatus}")
	public List<Trainings> getAllCourseDetailsByStatus(@PathVariable String courseStatus) {
		//String role="learner";
		System.out.println("course status is"+ courseStatus);
		System.out.println("In course info details  mapping..");
		//if(status=="completed" || status=="yet_to_start" || status=="inprogress")
			return (List<Trainings>) trainingdao.getCourseDetailsByStatus(courseStatus);
//		else
//			return null;
	}

}
