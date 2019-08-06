package com.pcsell.dao;

import com.pcsell.vo.Member;

public interface MemberDao {
	
	public void insertMember(Member member);
	
	Member selectMemberByIdAndPasswd(String id, String passwd);

	boolean loginCheck(Member vo);

	Member viewMember(Member vo);

	

}
