package com.mod.application.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.mod.application.model.Trainings;


//for using jpa related queries for trainings table from database
@Repository 
//for t_traings table in db
public interface TrainingsDao extends JpaRepository<Trainings, Long> {  //extends jpa repository for predefined method calls
	
	
	//to get the values from t_trainings in db w.r.t status
	@Query("FROM Trainings t WHERE t.status=?1")
	// to get the t_trainings table details w.r.t status from database
    List<Trainings> getCourseDetailsByStatus(String courseStatus);  //function to call in controller
	
	@Query(" FROM Trainings t where t.mntr_user_id=?1")
	public List<Trainings> getCourseDetails(int mntr_user_id);
	

		 @Query(value="select * from t_trainings   where  lrnr_user_id = ?1",nativeQuery = true)
		   public  List<Trainings> searchUserCourse(int id);
	 }
