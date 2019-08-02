package com.pcsell.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcsell.service.CartService;
import com.pcsell.vo.Upload;

@Controller
@RequestMapping(path = "/cart/")
public class CartController {
	
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
	@RequestMapping(value = "/view-cart", method = RequestMethod.GET)
	public String viewCart(Locale locale, Model model) {
		
		//데이터베이스에서 자료 목록 조회
		List<Upload> checkList = cartService.findCheckList();
		
		List<Upload> counts = cartService.count();

		//조회 결과를 request 객체에 저장 (JSP에서 사용할 수 있도록)
		model.addAttribute("checkList", checkList);  //name, price, count 가져옴
		model.addAttribute("countt", counts); //pccode가 일치하는 상품의 count를 가져옴

		return "cart";
	}
	
}
