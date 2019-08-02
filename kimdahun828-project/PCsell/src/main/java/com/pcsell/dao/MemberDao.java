package com.pcsell.dao;

import com.pcsell.vo.Member;

public interface MemberDao {
	
	void insertMember(Member member);
	
	Member selectMemberByIdAndPasswd(String id, String passwd);

}
