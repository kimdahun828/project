package com.pcsell.service;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductService {

	String registerProduct(Product product);
	
	void registerUploadFile(Photo photo);

}
