package com.pcsell.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcsell.service.MemberService;
import com.pcsell.vo.Member;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	//@Inject
	MemberService memberService;
	
	// 로그인 화면
	@RequestMapping(
			value="/login", 
			method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	// 회원 가입
	@RequestMapping(
			value="/register",
			method=RequestMethod.POST,
			produces="text/plain;charset=utf-8")
	@ResponseBody
	public String register(
			Member member, 
			@RequestParam("confirmPasswd") String confirmPasswd) {
		
		// 비밀번호와 비밀번호 확인이 다르면 오류 문자열을 던짐
		if (!member.getPasswd().equals(confirmPasswd)) {
			return MemberService.WRONG_PASSWD;
		}
		
		// 회원 가입 처리후, 결과에 따라 다른 문자열 반환
		return memberService.registerMember(member);
	}
	
	
	
	

}
