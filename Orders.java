package com.football.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	@ManyToOne
	@JoinColumn(name="emailId",nullable=false)
	private User emailId;
	private double totalPrice;
	
	private String City;
	private String State;
	private String Country;
	private int pincode;
	private String receiverName;
	private String receiverEmailId;
	private long receiverPhoneNo;
	
	//SETTER METHODS
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public void setEmailId(User emailId) {
		this.emailId = emailId;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setCity(String city) {
		City = city;
	}
	public void setState(String state) {
		State = state;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public void setReceiverEmailId(String receiverEmailId) {
		this.receiverEmailId = receiverEmailId;
	}
	public void setReceiverPhoneNo(long receiverPhoneNo) {
		this.receiverPhoneNo = receiverPhoneNo;
	}
	
	//SETTER METHODS
	
	//GETTER METHODS
	public long getOrderId() {
		return orderId;
	}
	public User getEmailId() {
		return emailId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public String getCity() {
		return City;
	}
	public String getState() {
		return State;
	}
	public String getCountry() {
		return Country;
	}
	public int getPincode() {
		return pincode;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public String getReceiverEmailId() {
		return receiverEmailId;
	}
	public long getReceiverPhoneNo() {
		return receiverPhoneNo;
	}
	//GETTER METHODS
	
	//TOSTRING METHOD
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", emailId=" + emailId + ", totalPrice=" + totalPrice + ", City=" + City
				+ ", State=" + State + ", Country=" + Country + ", pincode=" + pincode + ", receiverName="
				+ receiverName + ", receiverEmailId=" + receiverEmailId + ", receiverPhoneNo=" + receiverPhoneNo + "]";
	}
	
	//TOSTRING METHOD
	
	public Orders() {
		//EMPTY CONSTRUCTOR
	}
	
	//TAKE CONSTRUCTOR
	public Orders(User emailId, double totalPrice, String city, String state, String country, int pincode,
			String receiverName, String receiverEmailId, long receiverPhoneNo) {
		super();
		
		this.emailId = emailId;
		this.totalPrice = totalPrice;
		City = city;
		State = state;
		Country = country;
		this.pincode = pincode;
		this.receiverName = receiverName;
		this.receiverEmailId = receiverEmailId;
		this.receiverPhoneNo = receiverPhoneNo;
	}
	
	//TAKE CONSTRUCTOR
	

	

}
