package com.mod.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_TRAININGS")
public class Trainings {
	 public Trainings() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainings_id")
	private int trainings_id;
	private int course_id;
	private String course_nm;
	private int lrnr_user_id;
	private int mntr_user_id;
	private String lrnr_nm;
	private String mntr_nm;
	private String status;
	
	public int getTrainings_id() {
		return trainings_id;
	}
	public void setTrainings_id(int trainings_id) {
		this.trainings_id = trainings_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_nm() {
		return course_nm;
	}
	public void setCourse_nm(String course_nm) {
		this.course_nm = course_nm;
	}
	public int getLrnr_user_id() {
		return lrnr_user_id;
	}
	public void setLrnr_user_id(int lrnr_user_id) {
		this.lrnr_user_id = lrnr_user_id;
	}
	public int getMntr_user_id() {
		return mntr_user_id;
	}
	public void setMntr_user_id(int mntr_user_id) {
		this.mntr_user_id = mntr_user_id;
	}
	public String getLrnr_nm() {
		return lrnr_nm;
	}
	public void setLrnr_nm(String lrnr_nm) {
		this.lrnr_nm = lrnr_nm;
	}
	public String getMntr_nm() {
		return mntr_nm;
	}
	public void setMntr_nm(String mntr_nm) {
		this.mntr_nm = mntr_nm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Trainings [trainings_id=" + trainings_id + ", course_id=" + course_id + ", course_nm=" + course_nm
				+ ", lrnr_user_id=" + lrnr_user_id + ", mntr_user_id=" + mntr_user_id + ", lrnr_nm=" + lrnr_nm
				+ ", mntr_nm=" + mntr_nm + ", status=" + status + "]";
	}
	
	
	
	
}
