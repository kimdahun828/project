package com.pcsell.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcsell.service.CartService;
import com.pcsell.vo.Member;
import com.pcsell.vo.Product;

@Controller
@RequestMapping(path = "/cart/")
public class CartController {
	
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
	@RequestMapping(value = "/view-cart", method = RequestMethod.GET)
	public String viewCart(Locale locale, Model model, HttpSession session) {
		Member loginuser = (Member)session.getAttribute("loginuser");
		//데이터베이스에서 자료 목록 조회
		
		String name = loginuser.getId();
        
		Date date = new Date();

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", name); // loginuser의 name을 id로 저장
		params.put("cartdate", date); //오늘 날짜 형식을 DB꼴 yy/mm/dd 처럼 바꾸는 방법을 알아야 한다.
		
		List<Product> checkList = cartService.findCheckList(params);
		
//		List<Product> counts = cartService.count(); //시간 남으면 총합계 구하는 것 만들어보기.

		model.addAttribute("checkList", checkList);  //name, price, count 가져옴
//		model.addAttribute("countt", counts); //pccode가 일치하는 상품의 count를 가져옴

		return "cart";
	}

	@RequestMapping(value = "/cartadd" , method = RequestMethod.POST , produces = "text/plain;charset=utf-8")
	@ResponseBody 
	public String cartadd(Model model, String name, int price, HttpSession session) {
		Member loginuser = (Member)session.getAttribute("loginuser"); // 로그인 상태에서 id 받아가는 처리 해야 한다.
		

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("price", price);
		cartService.cartadd(params);
		
		return "productList";
	}
}
