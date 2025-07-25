package com.football.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.football.store.model.Product;
import com.football.store.model.User;
import com.football.store.services.ProductServices;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServices service;
	
	// ------ADD FOOTBALL PRODUCT------
	
	@GetMapping("/")
	public String displayIndex() {
		return "index";
	}
	
	@GetMapping("/showproductform")	//This is to add new Product Details in our form.
	public ModelAndView display() {
		return new ModelAndView("AddProduct","product",new Product());	//AddProduct: Name of the JSP File. | "product": An empty object so that value can be stored in it.
	}
	
	@PostMapping("/save")
	public String SaveProduct(@Valid @ModelAttribute Product product,@RequestPart("file") MultipartFile file) {		//Name Address and All the Data is fetched from the JSP page by using @ModelAttribute
		
		String msg=service.saveProduct(product, file);
		System.out.println((msg));
		return "ProdSuccess";
	}
	
	@GetMapping("/productList")		//This is to view the List of Product's that we have added.
	public ModelAndView displayProductList() {
		List<Product> productList = service.getALLProduct();
		
		return new ModelAndView("ProductList","flist",productList);		//Here (flist) is for the $ProductList
		//						"JSP PAGE"		"KEY" "VALUE"
		// The name ProductList should be same as the JSP page we have created.
	}
	
	//----------ADD FOOTBALL PRODUCT-------------
	
	// -------------- UPDATE PRODUCT -----------------
//	
//	@GetMapping("showUpdatedProduct")		//EDIT IT AND COMMENT THIS PART AS SHOWN IN PET_CONT
//	public ModelAndView displayUpdate() {
//		return new ModelAndView("UpdateProduct","product",new Product()); 	//UpdateUser: Name of the JSP File. | "product": An empty object so that value can be stored in it.
//	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@Valid@ModelAttribute Product product,@RequestPart("file") MultipartFile file) {	////Name address and all the data is fetched from the jsp page by using @modelAttribute
		String msg= service.saveProduct(product, file);
		System.out.println((msg));		//THIS SUCCESS PAGE WILL BE DISPLAYED ONCE THE PRODUCT IS UPDATED
		return "Success";
	}
	
	@GetMapping("/editProduct")
	public ModelAndView showUpdatedProduct(@RequestParam("productId") int productId) {
		Product product = service.getProductById(productId);
		return new ModelAndView("UpdateProduct","product",product);		//KEEP A NOTE OF THIS
	}
	
	
	// ---------------UPDATE PRODUCT -----------------
	
	//---------------DELETE PRODUCT------------------
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId) {
		service.deleteProductById(productId);
		return "ProductList";
	}
	

}
