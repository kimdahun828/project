package com.pcsell.repository;

import java.util.ArrayList;
import java.util.List;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductRepository {
	
	public List<Product> selectProduct();
	
	public List<Product> selectProductByCategory(String category);
		
	public String insertProduct(Product product);
		
	public void insertProductImage(Photo photo);
	
	public Product selectProductByPcCode(String pcCode);
	
	public List<Photo> selectProductImageByPcCode(String pcCode);
	
	public Photo selectProductImageBySavedFileName(String fileName);
	
	public void updateProduct(Product product);
	
	public void deleteProductImage(String savedFileName);
	
	public void deleteProduct(String pcCode);
	
	public Photo findProductImageByPcCode(String pcCode);

	public List<Product> selectCPU();

	public List<Product> selectMainBoard();

	public List<Product> selectVGA();

}
