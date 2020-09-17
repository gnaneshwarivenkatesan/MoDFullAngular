package com.mod.application.service;

import org.springframework.stereotype.Service;

import com.mod.application.model.Course;

@Service
public interface CourseService {
	public Course saveCourse(Course course);
	public Course findByCoursename(String coursename);

}
