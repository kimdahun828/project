package com.pcsell.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConnectController {
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOut(Locale locale, Model model) {

		return "checkout";
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
	
	@RequestMapping(value = "/memory", method = RequestMethod.GET)
	public String memoryList(Locale locale, Model model) {

		return "memory";
	}	
	
	@RequestMapping(value = "/dram", method = RequestMethod.GET)
	public String dramDetail(Locale locale, Model model) {
		// 이미지랑 설명 가져오면 됨

		return "detail";
	}	
	
}
