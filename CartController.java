package com.football.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.football.store.model.Cart;
import com.football.store.model.CartUpdate;
import com.football.store.model.Product;
import com.football.store.repository.CartRepository;
import com.football.store.services.CartServices;
import com.football.store.services.ProductServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    private final LoginController loginController;

	//-------FOOTBALL CART CONTROLLER--------
	
	@Autowired
	private CartServices cartservice;
	
	@Autowired
	private CartRepository crepo;
	
	@Autowired
	private ProductServices productservice;

    CartController(LoginController loginController) {
        this.loginController = loginController;
    }		
	
	@GetMapping("/addtocart")
	public String showaddCart(@RequestParam("productId")int productId, HttpSession session) {
		
		String userEmail=(String)session.getAttribute("userEmailId");	//KEEP A NOTE
		Product product = productservice.getProductById(productId);
		Cart c = new Cart();
		c.setCartQuantity(1);
		double totalprice=product.getProductPrice()*1;
		c.setTotalPrice(totalprice);
		c.setProduct(product);
		c.setCartEmailId(userEmail);//KEEP A NOTE
		cartservice.addCart(c);
		
		return "Success";
	}
	@GetMapping ("/cartList")
	public ModelAndView showCart(String cartEmailId,HttpSession session) {
		
		cartEmailId=(String)session.getAttribute("userEmailId");
		List<Cart> cartList = crepo.findByCartEmailId(cartEmailId);
		System.out.println(cartList);
		return new ModelAndView("CartList","clist",cartList);
		
	}
	
	//FOR INCREASE IN QUANTITY
	@PostMapping("updateCart")
	public String updateCart(@RequestBody CartUpdate Cup) {
		int cid = Cup.getCid();
		System.out.println("Cid"+cid);
		int quantity = Cup.getQuantity();			//All these variables are coming from CartUpdate.java
		System.out.println("quantity"+quantity);
		double totalPrice = Cup.getTotalPrice();
		System.out.println("Total price"+totalPrice);
		
		Cart c= crepo.findById(cid).get();
		c.setCartId(cid);;
		c.setCartQuantity(quantity);
		c.setTotalPrice(totalPrice);
		cartservice.addCart(c);
		
		return "/cartList";		//IF we want to show the cartList, send request back to the controller, so we have used /cartlist.
		//FOR INCREASE IN QUANTITY
		
	}
	
	@GetMapping("/deletecart")
	public String deleteCart(@RequestParam("cartId") int cartId) {
		cartservice.deleteCartById(cartId);		//TO DELETE THE PRODUCT FROM THE CARTLIST OF THE USER
		return "redirect:/cartList";
	}
	
	
}
