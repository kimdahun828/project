package com.pcsell.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcsell.service.MemberService;
import com.pcsell.vo.Host;
import com.pcsell.vo.Member;

@Controller
@RequestMapping(path = "/member/")
public class MemberController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;
	
	@RequestMapping(path = "register", method = RequestMethod.GET)
	public String showRegisterForm() {
		
		return "member/register"; // /WEB-INF/views/account/register.jsp
		
	}
	
	@RequestMapping(path = "register", method = RequestMethod.POST)
	public String register(Member member, String confirm) {//confirmPasswd
		
		if (!member.getPasswd().equals(confirm)) {
			return "redirect:/member/register";
		}
			
		memberService.registerMember(member);
		
		return "redirect:/member/login";
		
	}
	
	@RequestMapping(path = "login", method = RequestMethod.GET)
	public String showLoginForm() {
		
		return "member/login"; // /WEB-INF/views/account/login.jsp
		
	}
	
	@RequestMapping(path = "login", method = RequestMethod.POST)
	public String login(String id, String passwd, HttpSession session) {
				
		//2. 로그인 가능 여부 확인
		Member member = memberService.findMemberByIdAndPasswd(id, passwd);
		
		//3. 로그인 성공 또는 실패 처리
		if (member != null) { //로그인 가능 -> 로그인 처리 : 세션에 로그인 데이터 저장
			session.setAttribute("loginuser", member); //로그인 처리
			return "redirect:/"; 			
		} else { //로그인 실패
			return "member/login";			
		}
		
	}
	
	@RequestMapping(path = "/register_host", method = RequestMethod.GET)
	public String showHostRegisterForm() {
		return "member/register_host";
	}
	
	@RequestMapping(path = "/register_host", method = RequestMethod.POST)
	public String register(Host host, String confirm) {
		
		if (!host.getPasswd().equals(confirm)) {
			return "redirect:/member/register_host";
		}
			
		memberService.registerHost(host);
		
		return "redirect:/member/login";
		
	}
	
	@RequestMapping(path = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginuser");
		return "redirect:/";
		//return "redirect:/";
		
	}

}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

