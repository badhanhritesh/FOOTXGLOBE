package com.football.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	@Column
	@NotNull
	@NotBlank(message="USER NAME MUST NOT BE BLANK")	// THIS MESSAGE SHOULD BE DISPLAYED IF USERNAME ISN'T ENTERED..!
	@Size(min=3,max=20,message="USERNAME MUST BE BETWEEN 3 TO 20 CHARACTERS")
	private String userName;
	
	@Id				//This means that user_email will be the primary key
	@Email(message="EMAIL ID SHOULD BE VALID")
	@NotBlank(message="EMAIL IS REQUIRED")
	private String userEmail;
	
	@NotBlank(message="PASSWORD IS REQUIRED")
	@Size(min=8,message="PASSWORD MUST CONTAIN AT LEAST 8 CHARACTERS")
	private String userPassword;
	
	private String userAddress;
	
	@Digits(integer=10,fraction=0)		//Here fraction means numbers after the decimal(.)
	private long userContactNo;
	
	
	//SETTER METHODS
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setUserContactNo(long userContactNo) {
		this.userContactNo = userContactNo;
	}
	//SETTER METHODS

	//GETTER METHODS

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public long getUserContactNo() {
		return userContactNo;
	}

	//GETTER METHODS

	//TOSTRING METHOD
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userAddress=" + userAddress + ", userContactNo=" + userContactNo + "]";
	}
	//TOSTRING METHOD

	public User() {
		//EMPTY CONSTRUCTOR
	}

	
}
