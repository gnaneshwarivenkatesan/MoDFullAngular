package com.mod.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mod.application.model.Trainings;
import com.mod.application.service.LearnerViewService;

@RestController
@RequestMapping("/learner")

@CrossOrigin(origins = "http://localhost:4200")
public class LearnerViewController {
	
	@Autowired
	private LearnerViewService ls;
	

	@RequestMapping("/{id}")
	public List<Trainings> getUserCourse(@PathVariable Integer id) {
		return ls.getUserCourse(id);
	}
	
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public List<Trainings> getCourse() {
	
	return ls.getCourse();
	}
	
	@RequestMapping("/course/{id}")
	public Trainings getCourseDetails(@PathVariable Long id) {
	
		return ls.getById(id);
	}
	
	


}
