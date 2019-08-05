package com.pcsell.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pcsell.repository.CartRepository;
import com.pcsell.vo.Product;
 
public class CartServiceImpl implements CartService {
	

	private CartRepository cartRepository;	
	public CartRepository getCartRepository() {
		return cartRepository;
	}
	public void setCartRepository(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	@Override
	public void cartadd(HashMap<String, Object> params) {
		HashMap<String, Object> cartadd = cartRepository.addcart(params);
		return; // return값 없다. insert
		
	}
	@Override
	public List<Product> findCheckList(HashMap<String, Object> params) {
		ArrayList<Product> checkList = cartRepository.findCheckList(params);
		return checkList;
	}
	

}
