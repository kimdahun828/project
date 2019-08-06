package com.pcsell.repository;

import com.pcsell.vo.Member;

public interface MemberRepository {
	
	void insertMember(Member member);
	
	Member selectMemberByIdAndPasswd(String id, String passwd);

	Member viewMember(Member vo);

	boolean loginCheck(Member vo);

}
