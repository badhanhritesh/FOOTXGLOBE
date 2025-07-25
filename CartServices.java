package com.football.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.store.model.Cart;
import com.football.store.repository.CartRepository;

@Service
public class CartServices {
	
	@Autowired
	private CartRepository crepo;
	
	public String addCart(Cart cart) {
		
		crepo.save(cart);
		return "ADD TO CART";
	}
	
	public String deleteCartById(int id) {
		crepo.deleteById(id);		//TO DELETE FROM THE CARTLIST OF THE USER
		return "delete";
	}

}
