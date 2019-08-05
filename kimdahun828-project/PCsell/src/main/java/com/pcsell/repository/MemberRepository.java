package com.pcsell.repository;

import com.pcsell.vo.Member;

public interface MemberRepository {
	
	void insertMember(Member member);
	
	Member selectMemberByIdAndPasswd(String id, String passwd);

}
