package com.pcsell.mapper;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductMapper {

	void insertProduct(Product product);
	
	void insertProductImage(Photo photo);
}
