package com.football.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.football.store.model.User;
import com.football.store.services.UserServices;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	// CREATE User_Services and then import it here...!
	@Autowired
	private UserServices uservice;
	
	//----- ADD USER-----
	@GetMapping("/showAddUserform")
	public ModelAndView display() {
		return new ModelAndView("AddUser","auser",new User());				//"AddUser: JSP FILE | "auser": An empty object so that value could be stored inside it.
		
	}
	
	@PostMapping("/saveUser")
	public String SaveUser(@Valid @ModelAttribute User suser) {
		
		String msg= uservice.saveUser(suser);
		System.out.println((msg));
		return "Success";
		
	}
	
	@GetMapping("/userList")
	public ModelAndView displayUserList() {
		List <User> userList = uservice.getAllUser();
		
		return new ModelAndView("UserList","ulist",userList);
	}
//------ADD USER----------

	//------UPDATE CUSTOMER----------

	 @GetMapping("/showUpdatedUser")
	 public ModelAndView displayUpdate() {
		 return new ModelAndView("UpdateUser","user",new User());
	 }
	 
	 
	 @PostMapping("/updateUser")
	 public String updateUser(@Valid @ModelAttribute User user) {
		 String msg= uservice.saveUser(user);							//This uservice is from above Userservices
		 System.out.println((msg));
		 return "Success";
	 }
	
	//------UPDATE CUSTOMER----------

	
	
	
}
