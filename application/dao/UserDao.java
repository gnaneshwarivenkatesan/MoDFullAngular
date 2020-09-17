package com.mod.application.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mod.application.model.User;

//for using jpa related queries for t_user table from database
@Repository
public interface UserDao extends JpaRepository<User,Integer>{

	//to get the values from t_user table in db w.r.t status
	@Query("FROM User WHERE role=?1")
    List<User> getByRole(String role);
	
	//to get the values from t_user table in db w.r.t status and role
	@Query(" FROM User u where u.status=?1 and u.role=?2")
	public List<User> getByRoleAndStatus(String status,String role);

	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	public User findByUsernameAndRole(String username,String role);
	
	
}
