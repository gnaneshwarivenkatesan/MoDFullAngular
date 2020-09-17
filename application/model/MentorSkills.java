package com.mod.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="t_mntr_skills")
public class MentorSkills {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "skill_id ")
	private int skill_id;
	@Column(name="user_id")
	private int user_id;
	@Column(name="user_nm")
	private String username;
	@Column(name="course_id")
	private int courseId;
	@Column(name="course_desc")
	private String courseDescription;
	@Column(name="course_nm")
	private String coursename;
	@Column(name="status")
	private String status;
	@Column(name="is_active")
	private String is_active;
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
	

	
}
