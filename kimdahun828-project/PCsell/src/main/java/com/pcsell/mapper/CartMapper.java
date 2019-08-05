package com.pcsell.mapper; 

import java.util.HashMap;
import java.util.List;

import com.pcsell.vo.Product;


public interface CartMapper {

	List<Product> findCheckList(HashMap<String, Object> params);

	HashMap<String, Object> addcart(HashMap<String, Object> params);

}