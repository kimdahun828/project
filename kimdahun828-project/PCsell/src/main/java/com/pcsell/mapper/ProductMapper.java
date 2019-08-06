package com.pcsell.mapper;

import java.util.List;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductMapper {

	List<Product> selectProduct();
	
	List<Product> selectCPU();
	
	List<Product> selectMainBoard();
	
	List<Product> selectVGA();
	
	List<Product> selectProductByCategory(String category);
	
	void insertProduct(Product product);
	
	void insertProductImage(Photo photo);

	Product selectProductByPcCode(String pcCode);

	List<Photo> selectProductImageByPcCode(String pcCode);
	
	Photo selectProductImageBySavedFileName(String savedFileName);

	void updateProduct(Product product);

	void deleteProductImage(String savedFileName);

	void deleteProduct(String pcCode);

	Photo findProductImageByPcCode(String pcCode);
}
