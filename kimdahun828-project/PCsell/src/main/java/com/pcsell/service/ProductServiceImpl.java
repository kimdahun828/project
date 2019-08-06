package com.pcsell.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	@Override
	public List<Product> DramList() {
		ArrayList<Product> ramList = productRepository.DramList();
		return ramList;
	}

	@Override
	public List<Photo> dramFileListByPcCode(String pcCode) {
		ArrayList<Photo> ramFileList = productRepository.dramFileList(pcCode);
		return ramFileList;
	}

	@Override
	public List<Product> Dramdetail(String pcCode) {
		ArrayList<Product> ramDetailList = productRepository.DramDetail(pcCode);
		return ramDetailList;
	}

	@Override
	public List<Photo> dramDetailFileListByPcCode(Product product) {
		ArrayList<Photo> ramDetailFileList = productRepository.dramDetailFileListByPcCode(product);
		return ramDetailFileList;
	}

	@Override
	public List<Product> search(HashMap<String, Object> params) {
		ArrayList<Product> search = productRepository.search(params);
		return search;
	}

	@Override
	public List<Photo> searchFileListByPcCode(HashMap<String, Object> params) {
		ArrayList<Photo> searchFileListByPcCode = productRepository.searchFileListByPcCode(params);
		return searchFileListByPcCode;

	}
}
