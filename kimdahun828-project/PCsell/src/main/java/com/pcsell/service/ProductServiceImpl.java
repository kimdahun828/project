package com.pcsell.service;

import com.pcsell.repository.ProductRepository;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public String registerProduct(Product product) {
		String newPcCode = productRepository.insertProduct(product);
		for (Photo file : product.getFiles()) {
			file.setPcCode(newPcCode);
			productRepository.insertProductImage(file);
		}
		return newPcCode;
	}
	@Override
	public void registerUploadFile(Photo photo) {
		productRepository.insertProductImage(photo);
		
	}
	
}
