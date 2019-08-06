package com.pcsell.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.List;

import com.pcsell.vo.Cart;
import com.pcsell.vo.Product;


public interface CartService {

	void cartadd(String name);

	void ramCartAdd(String pcCode);

	List<Cart> ramCartList(Date date);

	List<Cart> checkOut(HashMap<String, Object> params);

	List<Cart> findCheckList2(HashMap<String, Object> params);

	List<Cart> findCheckList(String name);

	void cartDelete(HashMap<String, Object> params);

	List<Cart> cartSum(HashMap<String, Object> params);

} 