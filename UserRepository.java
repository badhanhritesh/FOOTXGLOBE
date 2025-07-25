package com.football.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.store.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByuserEmail(String userEmail);
	
	User findByUserEmailAndUserPassword(String userEmail,String userPassword);
	
	//The above String userEmailId and userPassword are coming from User.java
	//The First Letter of FindByUserEmailAndUserPassword should be capital to avoid any errors.
	//Accordingly changes will be made to LoginController and OrdersController

}
