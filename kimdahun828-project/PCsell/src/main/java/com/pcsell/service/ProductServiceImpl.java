package com.pcsell.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import com.pcsell.common.Pagination;
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

	@Override
	public int findMemoryListCnt(String category) {
		int memoryCnt = productRepository.findMemoryListCnt(category);
		return memoryCnt;
	}

	@Override
	public List<Product> findMemoryList(Pagination pagination, String category) {
		List<Product> products = productRepository.findMemoryList(pagination, category);
		
		return products;
	}

	@Override
	public List<Product> findProduct() {
		
		List<Product> products = productRepository.selectProduct();
		
		return products;
	}
	
	@Override
	public List<Product> findProductByCategory(String category) {
		
		List<Product> products = productRepository.selectProductByCategory(category);
		
		return products;
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
	public String registerProduct2(Product product) {
		String newPcCode = productRepository.insertProduct(product);

		return newPcCode;
	}
	
	@Override
	public void registerUploadFile(Photo photo) {
		productRepository.insertProductImage(photo);
		
	}

	@Override
	public Product findProductByPcCode(String pcCode) {
		
		Product product = productRepository.selectProductByPcCode(pcCode);
		
		return product;
	}

	@Override
	public List<Photo> findProductImage(String pcCode) {
		
		List<Photo> photo = productRepository.selectProductImageByPcCode(pcCode);	
	
		return photo;
	}
	
	@Override
	public Photo findProductImageBySavedFileName(String savedFileName) {
		
		Photo productImage = productRepository.selectProductImageBySavedFileName(savedFileName);
		
		return productImage;
	}

	@Override
	public void modifyProduct(Product product) {
		
		productRepository.updateProduct(product);
		
	}

	@Override
	public void deleteProductImage(String savedFileName) {
	
		productRepository.deleteProductImage(savedFileName);
		
	}

	@Override
	public void deleteProduct(String pcCode) {
	
		productRepository.deleteProduct(pcCode);
		
	}

	@Override
	public Photo findProductImageByPcCode(String pcCode) {
		
		Photo productImage = productRepository.findProductImageByPcCode(pcCode);
		
		return productImage;
	}

	@Override
	public List<Product> findCPU() {
		
		List<Product> cpu = productRepository.selectCPU();
		
		return cpu;
	}

	@Override
	public List<Product> findMainBoard() {
		
		List<Product> mainBoard = productRepository.selectMainBoard();
		
		return mainBoard;
	}

	@Override
	public List<Product> findVGA() {
		
		List<Product> vga = productRepository.selectVGA();
		
		return vga;
	}

	@Override
	public int findProductCount() {
		
		int productsCount = productRepository.selectProductCount();
		
		return productsCount;
	}
	
	@Override
	public List<Product> findProductWithPaging(HashMap<String, Object> params) {
		
		List<Product> products = 
				productRepository.selectProductWithPaging(params);
		
		return products;
	}

	@Override
	public List<Product> searchProductByName(String search) {
		
		search = "%" + search + "%";
		
		List<Product> searchProduct = productRepository.searchProductByName(search);
				
				
		return searchProduct;
	}

}
