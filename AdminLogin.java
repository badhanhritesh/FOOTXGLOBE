package com.football.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name="AdminTable")
public class AdminLogin {
	
	@Id
	@NotNull
	@NotBlank
	@Column
	private String adminEmailId;
	
	@NotNull 
	@NotBlank
	@Column
	private String adminPassword;

	//GETTER METHODS
	public String getAdminEmailId() {
		return adminEmailId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}
	//GETTER METHODS
	
	//SETTER METHODS

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	//SETTER METHODS METHODS
	//TOSTRING METHOD

	@Override
	public String toString() {
		return "AdminLogin [adminEmailId=" + adminEmailId + ", adminPassword=" + adminPassword + "]";
	}
	
	//TOSTRING METHOD
	
	public AdminLogin() {
		//EMPTY CONSTRUCTOR
	}

}
