package com.pcsell.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.pcsell.vo.Cart;
import com.pcsell.vo.Product;

public interface CartRepository {
	
	ArrayList<Cart> findCheckList2(HashMap<String, Object> params);

	ArrayList<Cart> findCheckList(String name);

	
	void addcart(String name);

	void ramCartAdd(HashMap<String, Object> params);

	ArrayList<Cart> ramCartList(Date date);

	ArrayList<Cart> checkOut(HashMap<String, Object> params);

	void cartDelete(HashMap<String, Object> params);

	ArrayList<Cart> cartSum(HashMap<String, Object> params);
}
