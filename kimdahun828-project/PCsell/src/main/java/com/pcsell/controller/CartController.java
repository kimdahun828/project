package com.pcsell.controller;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcsell.service.CartService;
import com.pcsell.vo.Cart;

@Controller
@RequestMapping(path = "/cart/")
public class CartController {
	
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
	@RequestMapping(value = "/view-cart", method = RequestMethod.GET)
	public String viewCart(Locale locale, Model model, HttpSession session) {
		//Member loginuser = (Member)session.getAttribute("loginuser");

		String id = null; // 로그인 구현 되면.. 우선.null

		Calendar cal = Calendar.getInstance();
		cal.isSet(Calendar.DAY_OF_WEEK);

		Date nestMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(nestMonth);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id); // 우선 name으로 만들고 ID로 수정해야 함.
		params.put("date", date);
		
		List<Cart> checklist = cartService.findCheckList2(params);
		List<Cart> cartSum = cartService.cartSum(params);

		model.addAttribute("checkList", checklist);  //name, price, count 가져옴
		model.addAttribute("cartSum", cartSum);

		return "cart";
	} 

	@RequestMapping(value = "/cartadd" , method = RequestMethod.POST)
	public String cartadd(Model model, @RequestParam(value = "pcCode") String pcCode , HttpSession session) {
		//Member loginuser = (Member)session.getAttribute("loginuser"); // 로그인 상태에서 id 받아가는 처리 해야 한다.
		cartService.ramCartAdd(pcCode);
		
		String name = null; // 로그인 유저 생기면 바꾸자.
		
		Calendar cal = Calendar.getInstance();
		cal.isSet(Calendar.DAY_OF_WEEK);
		
		Date nestMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(nestMonth);

		HashMap<String, Object> params = new HashMap<String, Object>();
//		params.put("id", id); // 우선 name으로 만들고 ID로 수정해야 함.
		params.put("date", date);
		
		List<Cart> checklist = cartService.findCheckList(name);
		List<Cart> cartSum = cartService.cartSum(params);
		
		model.addAttribute("checkList", checklist);
		model.addAttribute("cartSum", cartSum);
		
		return "cart";
		
	}

	
	@RequestMapping(value = "/cartadd2" , method = RequestMethod.POST)
	public String dramcartadd(Model model,  @RequestParam(value = "pcCode") String pcCode, HttpSession session) {
		//Member loginuser = (Member)session.getAttribute("loginuser"); // 로그인 상태에서 id 받아가는 처리 해야 한다.
		
		String id = null;
		cartService.ramCartAdd(pcCode); // 장바구니 담기
		
		Calendar cal = Calendar.getInstance();
		cal.isSet(Calendar.DAY_OF_WEEK);
		
		Date nestMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(nestMonth);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id); // 우선 name으로 만들고 ID로 수정해야 함.
		params.put("date", date);
		
		//List<Cart> ramCartAdd = cartService.ramCartList(date);
		List<Cart> checklist = cartService.findCheckList2(params);
		List<Cart> cartSum = cartService.cartSum(params);

		//model.addAttribute("ramCartList", ramCartAdd);
		model.addAttribute("checkList", checklist);
		model.addAttribute("cartSum", cartSum);
		return "cart";

	}
	
	@RequestMapping(value = "/checkoutt", method = RequestMethod.GET)
	public String checkOut(Locale locale, Model model) {

		String id = null;
		
		Calendar cal = Calendar.getInstance();
		cal.isSet(Calendar.DAY_OF_WEEK);
		
		Date nestMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(nestMonth);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id); // 우선 name으로 만들고 ID로 수정해야 함.
		params.put("date", date);
		
		//List<Cart> ramCartAdd = cartService.ramCartList(date);
		List<Cart> checklist = cartService.findCheckList2(params);
		List<Cart> cartSum = cartService.cartSum(params);
		
		model.addAttribute("checkList", checklist);
		model.addAttribute("cartSum", cartSum);
		
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkOutConnect(@RequestParam(value = "pcCode") String pcCode, Model model) {

		String id = null;
		
		Calendar cal = Calendar.getInstance();
		cal.isSet(Calendar.DAY_OF_WEEK);
		
		Date nestMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(nestMonth);
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id); // 우선 name으로 만들고 ID로 수정해야 함.
		params.put("date", date);
		//params.put("id", id); // 로그인 구현 되면 id에 해당되는 장바구니 결제

		List<Cart> checkOut = cartService.checkOut(params);		
		List<Cart> cartSum = cartService.cartSum(params);
		
		model.addAttribute("checkList", checkOut);
		model.addAttribute("cartSum", cartSum);
		
		return "checkout";
	}
	
	@RequestMapping(value = "/pay.action", method = RequestMethod.GET)
	public String Pay(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('결제 완료')");
		out.flush();
		
		return "redirect:checkout";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String viewCart(Model model) {

		//데이터베이스에서 자료 목록 조회
		String id = null; // 로그인을 하지 않으면 임의 test라는 이름으로 장바구니에 담게 해야 한다.
		
		Calendar cal = Calendar.getInstance();
		cal.isSet(Calendar.DAY_OF_WEEK);
		
		Date nestMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(nestMonth);
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id",id); // 우선 name으로 만들고 ID로 수정해야 함.
		params.put("date", date);
	
		cartService.cartDelete(params);

		List<Cart> checklist = cartService.findCheckList2(params);
		List<Cart> cartSum = cartService.cartSum(params);
		
		if (cartSum.isEmpty() && checklist.isEmpty()) {
			
		}
		
//		model.addAttribute("checkList", checklist);
//		model.addAttribute("cartSum", cartSum);
		
		return "voidCart";
	} 
	
}