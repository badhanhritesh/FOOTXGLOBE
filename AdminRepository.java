package com.football.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.store.model.AdminLogin;

public interface AdminRepository extends JpaRepository<AdminLogin,String > {
	
	AdminLogin findByAdminEmailIdAndAdminPassword(String adminEmailId,String adminPassword);
	
	//THE Above findByAdminEmailIdAndAdminPassword should be same as in the AdminLogin.java variable
	// The first letter for every word should be capital in findByAdminEmailIAndAdminPassword and accordingly changes will be made to OrdersController And LoginController
	// If first letter of findByAdminEmailIdAndAdminPassword is not capital as shown above,
	// NOTE VERY IMPORTANT: An error will occur so keep it as it is shown above to avoid any 
	// errors in the program. 
}
