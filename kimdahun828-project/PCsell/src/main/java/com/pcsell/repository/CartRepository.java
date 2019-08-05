package com.pcsell.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pcsell.vo.Product;

public interface CartRepository {

	HashMap<String, Object> addcart(HashMap<String, Object> params);

	ArrayList<Product> findCheckList(HashMap<String, Object> params);
}
