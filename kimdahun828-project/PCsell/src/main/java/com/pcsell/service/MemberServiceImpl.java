package com.pcsell.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pcsell.dao.MemberDao;
import com.pcsell.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	
	public static final String WRONG_PASSWD = "wrong_passwd";
	
	@Inject
	MemberDao memberDao;

	@Override
	public void registerMember(Member member) {
		// TODO Auto-generated method stub
	}

	@Override
	public Member findMemberByIdAndPasswd(String memberId, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

	public Member findMemberByIdPasswd(String id, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//회원 로그인 정보
	@Override
	public Member viewMember(Member vo) {
		return memberDao.viewMember(vo);
	}
	//회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	// 회원 로그인 체크
	@Override
	public boolean loginCheck(Member vo, HttpSession session) {
		boolean result = memberDao.loginCheck(vo);
		if (result) {
			Member vo2 = viewMember(vo);
			session.setAttribute("id", vo2.getId());
		}
		return result;
	}
	
		
		 

	
}
