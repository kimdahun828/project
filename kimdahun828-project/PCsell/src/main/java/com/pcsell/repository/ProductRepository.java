package com.pcsell.repository;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductRepository {
	
	public String insertProduct(Product product);
	
	void insertProductImage(Photo photo);
	
}
