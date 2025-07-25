package com.football.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.football.store.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	//--------------------- FOOTBALL CART REPOSITORY------------------------------
	
	List <Cart> findByCartEmailId(String cartEmailId);
	
	@Query("SELECT SUM(c.totalPrice) FROM Cart c WHERE c.cartEmailId =:email")		//The totalPrice and cartEmailId should be the variables that are used in the Cart.java File...!
			Double getTotalPriceSumByEmail(@Param("email")String email);
}
