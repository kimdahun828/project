package com.pcsell.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pcsell.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	
	public static final String WRONG_PASSWD = "wrong_passwd";

	@Override
	public void registerMember(Member member) {
		// TODO Auto-generated method stub
	}

	@Override
	public Member findMemberByIdAndPasswd(String memberId, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
