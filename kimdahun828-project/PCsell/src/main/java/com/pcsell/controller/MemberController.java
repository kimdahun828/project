package com.pcsell.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcsell.service.MemberServiceImpl;
import com.pcsell.vo.Member;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	
	
	//@Autowired
	MemberServiceImpl memberService;
	
	// 로그인 화면
	@RequestMapping(
			value="/login", 
			method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(
			path="/loginView", 
			method=RequestMethod.GET)
	public String loginView() {
		return "member/login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerView() {
		return "member/register";
	}
	
	// 로그인 처리
	@RequestMapping(path = "login", method = RequestMethod.POST)
	public String login(String id, String passwd, HttpSession session) {
		
		Member member = memberService.findMemberByIdPasswd(id, passwd);
		
		if (member != null) {
			session.setAttribute("loginuwer", member);
			return "redirect:/home";
		}else {
			return "account/login";
		}
	}
	
	// 로그아웃 처리
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginuser");
		return "redirect:/home";
	}
	
	// 회원 가입
		@RequestMapping(
				value="/register",
				method=RequestMethod.POST)
		public String register(Member member) {
			
			// 회원 가입 처리후, 결과에 따라 다른 문자열 반환
			//memberService.registerMember(member);
			
			return "redirect:/";
		}
	
	
	
	

}
