package com.pcsell.service;

import javax.servlet.http.HttpSession;

import com.pcsell.dao.MemberDao;
import com.pcsell.util.Util;
import com.pcsell.vo.Host;
import com.pcsell.vo.Member;


public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}	

	@Override
	public void registerMember(Member member) {
		String passwd = Util.getHashedString(member.getPasswd(), "SHA-256"); 
		member.setPasswd(passwd);
		
		memberDao.insertMember(member);
	}

	@Override
	public Member findMemberByIdAndPasswd(String id, String passwd) {
		passwd = Util.getHashedString(passwd, "SHA-256"); 
		Member member = memberDao.selectMemberByIdAndPasswd(id, passwd);

		return member;
	}
	
	public void insertHost(Host host) {
		memberDao.insertHost(host);
	}

	@Override
	public void registerHost(Host host) {
		String passwd = Util.getHashedString(host.getPasswd(), "SHA-256"); 
		host.setPasswd(passwd);
		
		memberDao.insertHost(host);
		
	}
	
	//회원 로그인 정보
	@Override
	public Member viewMember(Member member) {
		return memberDao.viewMember(member);
	}
	//회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	// 회원 로그인 체크
	@Override
	public boolean loginCheck(Member member, HttpSession session) {
		boolean result = memberDao.loginCheck(member);
		if (result) {
			Member vo2 = viewMember(member);
			session.setAttribute("id", vo2.getId());
		}
		return result;
	}
	
	
	@Override
	public void insertMember(Member member) {
		memberDao.insertMember(member);
		
	}
	
	
	
}
