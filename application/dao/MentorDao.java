package com.mod.application.dao;
//
//import java.sql.SQLException;
//import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mod.application.model.MentorSkills;

@Repository
public interface MentorDao extends JpaRepository<MentorSkills, Integer>  {
	
	
	@Query("from MentorSkills t where t.user_id=?1 and t.is_active=?2")
	public List<MentorSkills> getRegisteredCourse(int user_id,String course_status) throws Exception;
	@Transactional
	  @Modifying
	@Query("update MentorSkills t set t.is_active='inactive' where t.user_id=:user_id and t.courseId=:courseId" )
	public void deleteById(@Param(value="user_id")int user_id, @Param(value="courseId")int courseId);

	
	@Query("from MentorSkills t where t.coursename=?1")
	public List<MentorSkills> getMentor(@Param(value="coursename")String coursename);

	//public List<MentorSkills> registerCourse();
	
}

