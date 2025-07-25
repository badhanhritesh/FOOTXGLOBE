package com.football.store.model;

public class CartUpdate {
	
	private int cid;
	private int quantity;
	private double totalPrice;
	
	public CartUpdate() {
		//EMPTY CONSTRUCTOR
	}

	//---------------SETTER METHODS---------------

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	//---------------SETTER METHODS---------------
	
	//---------------GETTER METHODS---------------
	public int getCid() {
		return cid;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
	//---------------GETTER METHODS---------------

}
