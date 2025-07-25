package com.football.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="FF_Table")		// This will be the name of the table that will be created in the database.
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)		// This is for auto increment, as we want PET_ID to be auto-incremented.
	@Column
	private int productId;
	@Column
	private String productName;
	@Column
	private double productPrice;
	@Column
	private int productQuantity;
	@Column												//CHECK THIS WITH MAAM AND THEN REMOVE FROM COMMENTS..!
	private String imagePath;
	
	public Product() {
		//EMPTY CONSTRUCTOR
	}
	
	// SETTER METHODS 
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	// SETTER METHODS

	//GETTER METHODS
	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public String getImagePath() {
		return imagePath;
	}

	
	//GETTER METHODS
	
	
	//TO STRING METHOD
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", imagePath=" + imagePath + "]";
	}

	//TO STRING METHOD

	
	
}
