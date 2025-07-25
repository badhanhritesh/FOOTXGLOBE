package com.football.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.football.store.model.User;
import com.football.store.model.Orders;
import com.football.store.model.User;
import com.football.store.repository.CartRepository;
import com.football.store.repository.OrdersRepository;
import com.football.store.repository.UserRepository;
import com.football.store.services.OrdersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrdersController {
	
	@Autowired
	private CartRepository crepo;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private OrdersService oservice;
	
	@Autowired
	private OrdersRepository orepo;
	
	@GetMapping("/placeOrder")
	public ModelAndView displayOrder(HttpSession session) {	//This is going to CartList.jsp where form action=placeOrder
		//String emailId="Pain@123";
		String emailId=(String)session.getAttribute("userEmailId");		//KEEP A NOTE OF THIS LINE
		
		double totalprice=crepo.getTotalPriceSumByEmail(emailId);
		return new ModelAndView("Orders","tprice",totalprice);
	}
	
	@PostMapping("/saveOrder")
	public ModelAndView saveOrder(HttpServletRequest req,HttpSession session) {
	String emailId=(String)session.getAttribute("userEmailId");
		User usr = urepo.findByuserEmail(emailId);//KEEP A NOTE OVER HERE -- CHANGES TO BE MADE SIMILARLY IN USERREPOSITORY | This findByuserEmail is coming from userRepository
		String city = req.getParameter("City");
		String state = req.getParameter("State");
		String country = req.getParameter("Country");
		
		int pin = Integer.parseInt(req.getParameter("pincode"));
		
		String rname=req.getParameter("receiverName");
		String remail=req.getParameter("receiverEmailId");
		Long rphone=Long.parseLong(req.getParameter("receiverPhoneNo"));
		double tprice=Double.parseDouble(req.getParameter("totalPrice"));
		
		Orders order = new Orders(usr,tprice,city,state,country,pin,rname,remail,rphone);		//THIS SHOULD BE ACCORDING TO THE CONSTRUCTOR IN THE ORDERS.JAVA FILE
		Orders order1=oservice.saveOrder(order);
		
		return new ModelAndView("Payment","order",order1);
		
		
	}
	
	@GetMapping("/send")	
	public String sendEmail(HttpServletRequest req) {
		String emailId=req.getParameter("emailId");
		double TotalPrice=Double.parseDouble(req.getParameter("Total Price"));
		String subject ="TotalPrice"+TotalPrice;
		oservice.sendEmail(emailId, "Order Gets Placed", subject);
		return "Email send Successfully to" + "almasbags28@gmail.com";
	}
	

}
 