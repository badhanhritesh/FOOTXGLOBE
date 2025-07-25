package com.football.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.football.store.model.AdminLogin;
import com.football.store.model.User;
import com.football.store.repository.AdminRepository;
import com.football.store.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository usrrepo;
	
	@Autowired
	private AdminRepository adminrepo;
	
	@GetMapping("/showLogin")
	public String Login() {
		return "Login";
	}
	
	//---------THIS CODE IS WITH Login.jsp file the values for email id and password are same as in Login.jsp-------------
	@PostMapping("/Login")			// This /Login comes from the Login.jsp page action tag
	public String saveLogin(HttpServletRequest req,HttpSession session) {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User usr = usrrepo.findByUserEmailAndUserPassword(email, pass);	//KEEP NOTE CHANGES ARE TO BE MADE FROM USERREPOSITORY  | This findByuserEmail and userPassword is coming from UserRepository
		AdminLogin admin = adminrepo.findByAdminEmailIdAndAdminPassword(email,pass);		//KEEP A NOTE HERE AN ERROR ARISES  - CHANGES TO BE MADE FROM ADMINREPOSITORY | This findByAdminEmailId and AdminPassword is coming from AdminRepository
		//SO TO SOLVE THAT ERROR WE NEED TO GO TO AdminRepository and make changes in that file to solve this error.
		if(usr!=null) {
			session.setAttribute("userEmailId", email);//This is going to header.jsp inside the if condition.
			return "index";
		}
		else if(admin!=null) {
			session.setAttribute("adminEmailId", email);//This is also going to header.jsp inside the if condition.
			return "index";
		}
		else {
			return "Failed";
		}
	}
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {		//Session gets invalid you will come out of the session for logout purpose..!
			session.invalidate();
			return "index";
		
	}

}
