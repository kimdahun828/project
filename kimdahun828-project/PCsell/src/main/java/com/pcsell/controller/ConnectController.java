package com.pcsell.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcsell.service.CartService;
import com.pcsell.vo.Product;

@Controller
public class ConnectController {

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String viewCart(Locale locale, Model model) {

		return "productList";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Locale locale, Model model) {

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
