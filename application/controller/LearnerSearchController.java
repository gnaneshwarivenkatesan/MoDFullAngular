package com.mod.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mod.application.dao.CourseDao;
import com.mod.application.model.Course;
import com.mod.application.model.MentorSkills;

import com.mod.application.model.Trainings;
import com.mod.application.model.User;
import com.mod.application.service.LearnerSearchService;
import com.mod.application.service.LearnerViewService;

@RestController
//
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/learner")
public class LearnerSearchController {
	
	@Autowired
	LearnerSearchService learnerSearch;
	
	@Autowired
	LearnerViewService lvs;
	
	@Autowired
	CourseDao courseDao;
	
	@GetMapping("/search/{lrnr_user_id}")
	public List<Course> getCourse(@PathVariable int lrnr_user_id){
		String courseStatus="active";
		return (List<Course>) courseDao.getByCourseStatus(courseStatus,lrnr_user_id);
	}
//	
//	@GetMapping("/{role}/{status}")
//	public List<User> getUserByRoleandStatus(@PathVariable String role,@PathVariable String status) {
//		//String role="learner";
//		System.out.println("status is "+ status);
//		System.out.println("role is "+ role);
//		System.out.println("In Role n Status (learners and mentor) ,active and Inactive mapping....");
//		
//		return (List<User>) userdao.getByRoleAndStatus(status,role);
//	
//	}
	
	
	@GetMapping(value="/filter")
	public List<MentorSkills> getmentor(@RequestParam String coursename)
	{
		return learnerSearch.getMentor(coursename);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addCourse")
	public void addCourse(@RequestBody Trainings cd) {	
		lvs.addCourse(cd);	
	}
	
	
}
