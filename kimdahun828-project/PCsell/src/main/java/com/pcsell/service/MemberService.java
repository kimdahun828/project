package com.pcsell.service;

import com.pcsell.vo.Member;

public interface MemberService {
	
	void registerMember(Member member);
	
	Member findMemberByIdAndPasswd(String memberId, String passwd);

}
