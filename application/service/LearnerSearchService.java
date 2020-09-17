package com.mod.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mod.application.dao.MentorDao;
import com.mod.application.dao.TrainingsDao;
import com.mod.application.model.MentorSkills;

import com.mod.application.model.Trainings;

@Service
public class LearnerSearchService {

	
	
	@Autowired
	MentorDao mentorDao;
	
	@Autowired
	TrainingsDao trainingsDao;
	
	
	public List<MentorSkills> getMentorCourse(){
		List<MentorSkills> list=new ArrayList<>();
		mentorDao.findAll().forEach(list::add);
		return list;
	}
	public void addCourse(Trainings lm) {
		  trainingsDao.save(lm);
	}
	
	
	public List<MentorSkills> getMentor(String coursename)
	{
		return mentorDao.getMentor(coursename);
	}
	
	
	
	
}
