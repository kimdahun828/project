package com.pcsell.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.pcsell.mapper.MemberMapper;
import com.pcsell.vo.Host;
import com.pcsell.vo.Member;

public class MemberDaoImpl implements MemberDao {
	
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	private MemberMapper memberMapper;

	public MemberMapper getMemberMapper() {
		return memberMapper;
	}

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	

	@Override
	public Member selectMemberByIdAndPasswd(String id, String passwd) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("passwd", passwd);
		
		Member member = memberMapper.selectMemberByIdAndPasswd(params);
		
		return member;
	}

	@Override
	public void insertMember(Member member) {
		memberMapper.insertMember(member);
	}
	
	public void insertHost(Host host) {
		memberMapper.insertHost(host);
	}

	@Override
	public boolean loginCheck(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member viewMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
 
    

}
