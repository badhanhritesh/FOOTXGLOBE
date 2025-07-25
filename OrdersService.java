package com.football.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.football.store.model.Orders;
import com.football.store.repository.OrdersRepository;



@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository orepo;
	
	@Autowired
	private JavaMailSender mailSender;		//Imported this by adding dependency.
	
	public Orders saveOrder(Orders order)
	{
		Orders order1=orepo.save(order);
		return order1;
	}
	
	public void sendEmail(String toEmail,String subject,String body) {
		SimpleMailMessage message = new SimpleMailMessage();	//CHECK ERROR..!
		message.setFrom("hritbad@gmail.com");		//Enter the mail id which is working.!
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);			//CHECK ERROR...!
		
		System.out.println("MAIL SENT SUCCESSFULLY..!");
	}

}
