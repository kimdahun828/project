package com.pcsell.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pcsell.mapper.CartMapper;
import com.pcsell.vo.Upload;

public class CartDaoImpl implements CartDao {
	
	//JDBC의 구조 코드를 단순하게 만드는 스프링의 클래스
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private CartMapper cartMapper;
	public CartMapper getCartMapper() {
		return cartMapper;
	}
	public void setCartMapper(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public ArrayList<Upload> findCheckList() {
		List<Upload> checkList = cartMapper.findCheckList();
		return (ArrayList<Upload>)checkList;
	}
	
	@Override
	public ArrayList<Upload> count() {
		List<Upload> counts = cartMapper.count();
		return (ArrayList<Upload>)counts;
	}
	
	
}


