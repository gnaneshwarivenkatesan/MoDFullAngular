package com.mod.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="T_USER")
public class User {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	@Column(name="user_id")
//	private int user_id;
	@Column(name="user_nm")
	private String username;
	
	@Column(name="user_fullnm")
	private String userfullname;
	
	private String email;
	private String role;
	private String status="active";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserfullname() {
		return userfullname;
	}
	public void setUserfullname(String userfullname) {
		this.userfullname = userfullname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", usernm=" + username + ", userfullnm=" + userfullname + ", email=" + email + ", role="
				+ role + ", status=" + status + "]";
	}

	



}
