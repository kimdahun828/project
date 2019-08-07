package com.pcsell.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pcsell.mapper.CartMapper;
import com.pcsell.vo.Cart;

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
	public ArrayList<Cart> findCheckList2(HashMap<String, Object> params) {
		List<Cart> checkList = cartMapper.findCheckList2(params);

		return (ArrayList<Cart>)checkList;
	}
	
	@Override
	public void addcart(String name) {
		cartMapper.addcart(name);
	}
	
	@Override
	public void ramCartAdd(String pcCode) {
		cartMapper.ramCartAdd(pcCode);	
	}
	
	@Override
	public ArrayList<Cart> ramCartList(Date date) {
		List<Cart> ramCartList = cartMapper.ramCartList(date); 
		return (ArrayList<Cart>)ramCartList;
	}
	
	@Override
	public ArrayList<Cart> checkOut(HashMap<String, Object> params) {
		List<Cart> checkOut = cartMapper.checkOut(params); 
		return (ArrayList<Cart>)checkOut;
	}
	
	@Override
	public ArrayList<Cart> findCheckList(String name) {
		List<Cart> checkList = cartMapper.findCheckList(name); 
		return (ArrayList<Cart>)checkList;
	}
	
	@Override
	public void cartDelete(HashMap<String, Object> params) {
		cartMapper.cartDelete(params); 
	}
	
	@Override
	public ArrayList<Cart> cartSum(HashMap<String, Object> params) {
		List<Cart> cartSum = cartMapper.cartSum(params); 
		return (ArrayList<Cart>)cartSum;
	}

}


