package com.pcsell.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.pcsell.mapper.MemberMapper;
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
	
	@Inject
    private SqlSession session;

	@Override
	public void insertMember(Member member) {

		session.insert("insertMember",member);
		
	}

	@Override
	public Member selectMemberByIdAndPasswd(String id, String passwd) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("memberId", id);
		params.put("passwd", passwd);
		
		Member member = memberMapper.selectMemberByIdAndPasswd(params);
		
		return member;
	}

	@Override
	public boolean loginCheck(Member vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member viewMember(Member vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
 
    

}
