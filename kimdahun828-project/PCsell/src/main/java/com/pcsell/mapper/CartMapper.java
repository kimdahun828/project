package com.pcsell.mapper; 

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.pcsell.vo.Cart;

public interface CartMapper {

	List<Cart> findCheckList2(HashMap<String, Object> params);
	List<Cart> findCheckList(String name);

	void addcart(String name);

	void ramCartAdd(HashMap<String, Object> params);

	List<Cart> ramCartList(Date date);

	List<Cart> checkOut(HashMap<String, Object> params);
	
	void cartDelete(HashMap<String, Object> params);
	
	List<Cart> cartSum(HashMap<String, Object> params);


}