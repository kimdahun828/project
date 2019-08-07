package com.pcsell.controller;


import java.util.ArrayList;
import java.util.HashMap;
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
import com.pcsell.service.ProductService;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

@Controller
public class ConnectController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@RequestMapping(value = "/productList")
	public String viewCart(Model model) {

		int pageSize = 9;
		int currentPage = 1;
		
		int from = (currentPage - 1) * pageSize + 1;
		int to = from + pageSize;
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("from", from);
		params.put("to", to);
		
		List<Product> products = productService.findProductWithPaging(params);
		
		for (Product product : products) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
		
		model.addAttribute("products", products);
			
		int productsCount = productService.findProductCount();
		model.addAttribute("productsCount", productsCount);
		
		return "productList";
	}
	
	@RequestMapping(value = "/product-list")
	public String viewProductPage(Model model, int pageNo) {

		int pageSize = 9;
		int currentPage = pageNo;
		
		int from = (currentPage - 1) * pageSize + 1;
		int to = from + pageSize;
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("from", from);
		params.put("to", to);
		
		List<Product> products = productService.findProductWithPaging(params);
		
		for (Product product : products) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
	
		model.addAttribute("products", products);
		
		return "productsView";
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
		
		List<Product> products = productService.findProduct();
		for (Product product2 : products) {
			List<Photo> photo2 = productService.findProductImage(product2.getPcCode());
			product2.setFiles(photo2);
		}
		model.addAttribute("products", products);
		
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
