package com.football.store.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.football.store.model.Product;
import com.football.store.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository repo;
	
	String uploadDir="C://Users//santo//Documents//workspace-spring-tools-for-eclipse-4.30.0.RELEASE//Foot_FutBallStore//src//main//resources//static//images//";

	public String saveProduct(Product prodobj,MultipartFile file) {	//MultipartFile Is used to take the file from services to Controller
		
		File directory = new File(uploadDir);		//File is used to create a new file in the uploadDir
		System.out.println(directory.getPath());
		if(!directory.exists()) {
			directory.mkdir();
		}
		String filePath = uploadDir+file.getOriginalFilename();
		System.out.println();
		
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Surrounded with try catch, as it throws an exception
		
		prodobj.setImagePath(file.getOriginalFilename());
		repo.save(prodobj);
		return " FOOTBALL OBJECT IS SAVED SUCCESFULLY..!";
		
	}
	public List<Product>getALLProduct(){
		return repo.findAll();
	}
	
	public Product getProductById(int id) {	//THIS STATEMENT IS SAME AS : Select * from Pet where id=?;
		return repo.findById(id).get();
		
	}
	
	public String deleteProductById(int id) {
		repo.deleteById(id);
		return "delete";
	}
}
