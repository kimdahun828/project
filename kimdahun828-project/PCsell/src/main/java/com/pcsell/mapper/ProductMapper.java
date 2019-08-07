package com.pcsell.mapper;

import java.util.HashMap;
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
////////////////////////////////////////////////////////////////////////////////////////////////////
	List<Product> dramList();
	List<Photo> dramFileList(String pcCode);

	List<Product> dramDetailList(String pcCode);
	List<Photo> dramDetailFileListByPcCode(Product product);

	List<Product> search(HashMap<String, Object> params);

	List<Photo> searchFileListByPcCode(HashMap<String, Object> params);

	int findMemoryListCnt(HashMap<String, Object> param);

	List<Product> findMemoryList(HashMap<String, Object> params);
/////////////////////////////////////////////////////////////////////////////////////////////////////
	Product selectProductByPcCode(String pcCode);

	List<Photo> selectProductImageByPcCode(String pcCode);
	
	Photo selectProductImageBySavedFileName(String savedFileName);

	void updateProduct(Product product);

	void deleteProductImage(String savedFileName);

	void deleteProduct(String pcCode);

	Photo findProductImageByPcCode(String pcCode); // 최종 22개 class
}
 