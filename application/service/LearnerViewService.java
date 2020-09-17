package com.mod.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mod.application.dao.TrainingsDao;


import com.mod.application.model.Trainings;

@Service
public class LearnerViewService {
	@Autowired
	private TrainingsDao trainingsDao;
	
	public List<Trainings> getCourse() {
		List<Trainings> list=new ArrayList<>();
		trainingsDao.findAll().forEach(list::add);
	
		return list;
	}
	
	public Trainings getById(Long id) {
		return trainingsDao.findById(id).orElse(null);
	}
	
	public void addCourse(Trainings cd) {
		trainingsDao.save(cd);
	}

	
	public List<Trainings> getUserCourse(Integer id) {
		return trainingsDao.searchUserCourse(id);
	}


}
