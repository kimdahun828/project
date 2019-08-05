package com.pcsell.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pcsell.mapper.CartMapper;
import com.pcsell.vo.Product;

public class CartRepositoryImpl implements CartRepository {
	
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
	public ArrayList<Product> findCheckList(HashMap<String, Object> params) {
		List<Product> checkList = cartMapper.findCheckList(params);
		return (ArrayList<Product>)checkList;
	}
	@Override
	public HashMap<String, Object> addcart(HashMap<String, Object> params) {
		HashMap<String, Object> cartadd = cartMapper.addcart(params);
		return cartadd;
	}
	
	
}


