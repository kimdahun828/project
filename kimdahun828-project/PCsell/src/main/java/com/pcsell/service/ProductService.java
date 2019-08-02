package com.pcsell.service;

import com.pcsell.dao.ProductDao;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public class ProductService {

	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public String registerProduct(Product product) {
		String newPcCode = productDao.insertProduct(product);
		for (Photo file : product.getFiles()) {
			file.setPcCode(newPcCode);
			productDao.insertProductImage(file);
		}
		return newPcCode;
	}

	public void registerUploadFile(Photo photo) {
		productDao.insertProductImage(photo);
		
	}
	
}
