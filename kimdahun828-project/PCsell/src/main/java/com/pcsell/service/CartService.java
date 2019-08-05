package com.pcsell.service;

import java.util.HashMap;
import java.util.List;

import com.pcsell.vo.Product;

public interface CartService {

	List<Product> findCheckList(HashMap<String, Object> params);

	void cartadd(HashMap<String, Object> params);

}