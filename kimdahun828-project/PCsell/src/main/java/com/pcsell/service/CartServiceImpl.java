package com.pcsell.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.pcsell.repository.CartRepository;
import com.pcsell.vo.Cart;
 
public class CartServiceImpl implements CartService {
	

	private CartRepository cartRepository;	
	public CartRepository getCartRepository() {
		return cartRepository;
	}
	public void setCartRepository(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	@Override
	public void cartadd(String name) {
		cartRepository.addcart(name);
	}
	
	@Override
	public List<Cart> findCheckList2(HashMap<String, Object> params) {
		ArrayList<Cart> checkList = cartRepository.findCheckList2(params);

		return checkList;
	}
	@Override
	public void ramCartAdd(HashMap<String, Object> params) {
		cartRepository.ramCartAdd(params);
	}
	
	@Override
	public List<Cart> ramCartList(Date date) {
		ArrayList<Cart> ramCartList = cartRepository.ramCartList(date);
		return ramCartList;
	}
	@Override
	public List<Cart> checkOut(HashMap<String, Object> params) {
		ArrayList<Cart> checkOut = cartRepository.checkOut(params);
		return checkOut;
	}
	@Override
	public List<Cart> findCheckList(String name) {
		ArrayList<Cart> checkList = cartRepository.findCheckList(name);
		return checkList;
	}
	@Override
	public void cartDelete(HashMap<String, Object> params) {
		cartRepository.cartDelete(params);
	}
	@Override
	public List<Cart> cartSum(HashMap<String, Object> params) {
		ArrayList<Cart> cartSum = cartRepository.cartSum(params);
		return cartSum;
	}
	

}
