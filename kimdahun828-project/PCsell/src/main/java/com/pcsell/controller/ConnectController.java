package com.pcsell.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConnectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectController.class);
	
	@RequestMapping(value = "/view-cart", method = RequestMethod.GET)
	public String viewCart(Locale locale, Model model) {

		return "basket";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOut(Locale locale, Model model) {

		return "checkout";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Locale locale, Model model) {

		return "detail";
	}
	
}
