package com.mod.application.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mod.application.model.Course;
@Repository
public interface CourseDao extends CrudRepository<Course, Integer> {
	
	public Course findByCoursename(String coursename);
	
	@Query("from Course c where c.coursename NOT IN (select t.course_nm from Trainings t where t.lrnr_user_id=?2) and c.courseStatus=?1 ")
	public List<Course> getByCourseStatus(String courseStatus,int lrnr_user_id);
	
	@Query("select c from Course c where c.coursename LIKE %:letter%")
	public List<Course> findByCourse(@Param(value="letter") String letter);
	
	
	@Query("select c from Course c where c.coursename NOT IN (select m.coursename from MentorSkills m where m.user_id=?1 and m.is_active='active')")
	public List<Course> findCourseName(@Param(value="user_id") int user_id);

}
