package com.pcsell.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pcsell.mapper.MemberMapper;
import com.pcsell.vo.Member;

public class MemberRepositoryImpl implements MemberRepository {
	
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
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

	public void insertMember(Member member) {

		memberMapper.insertMember(member);
		
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
	public Member viewMember(Member vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginCheck(Member vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
