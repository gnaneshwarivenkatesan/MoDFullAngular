package com.mod.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COURSE")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id ")
	private long courseId;
	@Column(name="course_nm")
	private String coursename;
	@Column(name="course_desc")
	private String courseDescription;
	@Column(name="course_status")
	private String courseStatus="active";
	/*
	 * @OneToOne(optional = false, cascade = CascadeType.MERGE, fetch =
	 * FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "userId") private User user;
	 */

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@Column(name = "course_nm")
	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	@Column(name = "course_desc")
	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */
	@Column(name = "status")
	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", coursename=" + coursename + ", courseDescription="
				+ courseDescription + "]";
	}

}
