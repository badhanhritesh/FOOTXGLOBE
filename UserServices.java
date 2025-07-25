package com.football.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.football.store.model.User;
import com.football.store.repository.UserRepository;
import com.football.store.controller.UserController;


@Service
public class UserServices {
	
	@Autowired
	private UserRepository urepo;
	
	public String saveUser(User userobj) {
		
		urepo.save(userobj);							
		return " CUSTOMER OBJECT CREATED SUCCESSFULLY";
	}
		
		public List <User>getAllUser(){
			return urepo.findAll();				
		}	
	

}
