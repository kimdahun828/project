package com.pcsell.repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pcsell.common.Pagination;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductRepository {

	public ArrayList<Product> DramList();

	public ArrayList<Photo> dramFileList(String pcCode);

	public ArrayList<Product> DramDetail(String pcCode);

	public ArrayList<Photo> dramDetailFileListByPcCode(Product product);

	public ArrayList<Product> search(HashMap<String, Object> params);

	public ArrayList<Photo> searchFileListByPcCode(HashMap<String, Object> params);

	public List<Product> findMemoryList(Pagination pagination, String category);

	public int findMemoryListCnt(String category);
	
//////////////////////////////////////////////////////////////////////////////////////////////
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

	public int selectProductCount();

	public List<Product> selectProductWithPaging(HashMap<String, Object> params);

	public List<Product> searchProductByName(String search);

}
