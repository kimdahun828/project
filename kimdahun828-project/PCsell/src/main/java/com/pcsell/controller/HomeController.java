package com.pcsell.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcsell.service.ProductService;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<Product> products = productService.findProduct();
		List<Product> cpu = productService.findCPU();
		List<Product> mainBoard = productService.findMainBoard();
		List<Product> vga = productService.findVGA();
		
		for (Product product : products) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
		for (Product product : cpu) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
		for (Product product : mainBoard) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
		for (Product product : vga) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
		
		model.addAttribute("products", products);
		model.addAttribute("cpu", cpu);
		model.addAttribute("mainBoard", mainBoard);
		model.addAttribute("vga", vga);
		
		return "home";
	}
	
}