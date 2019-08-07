package com.pcsell.dao;

import com.pcsell.vo.Host;
import com.pcsell.vo.Member;

public interface MemberDao {
	
	void insertMember(Member member);
	
	void insertHost(Host host);
	
	Member selectMemberByIdAndPasswd(String id, String passwd);

	boolean loginCheck(Member vo);

	Member viewMember(Member vo);

	

}
