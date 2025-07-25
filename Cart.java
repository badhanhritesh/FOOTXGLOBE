package com.football.store.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Cart {

	// ----------CART FOR FOOTBALL STORE--------------
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	private int cartQuantity;
	private String cartEmailId;
	private double totalPrice;
	//@ManyToOne(cascade=CascadeType.ALL	Many Carts will have one id we can do both the ways
		// Also make sure you drop the cart table when you are doing using One-One and Many-One while using add to cart feature
		//As we saw if one to one is selected and you run this program it shows white label error because one cartid has only one petid
	//HERE WE USE MANYTOONE SEE IT AND MAKE CHANGES ACCORDINGLY
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="productId",referencedColumnName="productId")				//This is product_Id from Product.java File.
	private Product product;
	
	public Cart() {
		//EMPTY CONSTRUCTOR
	}
	
	//----------------SETTER METHODS-------------------


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public void setCartEmailId(String cartEmailId) {
		this.cartEmailId = cartEmailId;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	//----------------SETTER METHODS-------------------
	
	//----------------GETTER METHODS------------------------

	
	public int getCartId() {
		return cartId;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public String getCartEmailId() {
		return cartEmailId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public Product getProduct() {
		return product;
	}	
	//----------------GETTER METHODS------------------------
	
	
	//---------------TOSTRING METHOD---------------------
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartQuantity=" + cartQuantity + ", cartEmailId=" + cartEmailId
				+ ", totalPrice=" + totalPrice + ", product=" + product + "]";
	}
	
	//---------------TOSTRING METHOD---------------------
	

	
	
	
	
	
}
