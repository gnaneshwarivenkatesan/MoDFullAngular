package com.mod.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mod.application.dao.CourseDao;
import com.mod.application.model.Course;
@Service
public class CourseServiceImp implements CourseService {
	@Autowired
	CourseDao coursedao;

	@Override
	public Course saveCourse(Course course) {
		return coursedao.save(course);
	}

	@Override
	public Course findByCoursename(String coursename) {
		return coursedao.findByCoursename(coursename);
	}

}
