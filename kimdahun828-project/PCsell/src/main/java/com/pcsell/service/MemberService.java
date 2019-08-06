package com.pcsell.service;

import javax.servlet.http.HttpSession;

import com.pcsell.vo.Member;

public interface MemberService {
	
	public void insertMember(Member member);
	
	void registerMember(Member member);
	
	Member findMemberByIdAndPasswd(String memberId, String passwd);

	Member viewMember(Member vo);

	void logout(HttpSession session);

	boolean loginCheck(Member vo, HttpSession session);

}
