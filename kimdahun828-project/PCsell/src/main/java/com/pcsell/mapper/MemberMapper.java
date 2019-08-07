package com.pcsell.mapper;

import java.util.HashMap;

import com.pcsell.vo.Host;
import com.pcsell.vo.Member;

public interface MemberMapper {
	
	void insertMember(Member member);
		
	Member selectMemberByIdAndPasswd(HashMap<String, Object> params);

	void insertHost(Host host);
	

}
