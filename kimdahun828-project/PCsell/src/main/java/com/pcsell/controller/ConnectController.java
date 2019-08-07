package com.pcsell.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcsell.service.CartService;
import com.pcsell.vo.Product;

import com.pcsell.service.ProductService;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

@Controller
public class ConnectController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String viewCart(Locale locale, Model model) {

		List<Product> products = productService.findProduct();
		
		for (Product product : products) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
		
		model.addAttribute("products", products);
			
		return "productList";
	}
	

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOut(Locale locale, Model model) {

		return "checkout";
	}
	
	@RequestMapping(value = "/detail/{pcCode}", method = RequestMethod.GET)
	public String detail(@PathVariable String pcCode, Model model) {

		Product product = productService.findProductByPcCode(pcCode);
		
		if (product == null) {
			return "redirect:productList";
		}
		
		List<Photo> photo = productService.findProductImage(pcCode);
		product.setFiles((ArrayList<Photo>)photo);
		
		model.addAttribute("product", product);
		model.addAttribute("photo", photo);
		
		return "detail";
	}
	
	@RequestMapping(value = "/laptop", method = RequestMethod.GET)
	public String laptopList(Locale locale, Model model) {

		return "laptop"; 
	}
	
	@RequestMapping(value = "/accessories", method = RequestMethod.GET)
	public String accessoriesList(Locale locale, Model model) {

		return "accessories"; 
	}
	
	
}
