package com.pcsell.service;


import java.util.HashMap;
import java.util.List;


import com.pcsell.common.Pagination;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductService {

	///////////////////////////////////////////////////////////////////////////////
	List<Product> DramList();

	List<Photo> dramFileListByPcCode(String pcCode);

	List<Product> Dramdetail(String pcCode);

	List<Photo> dramDetailFileListByPcCode(Product product);

	List<Product> search(HashMap<String, Object> params);
	List<Photo> searchFileListByPcCode(HashMap<String, Object> params);

	public List<Product> findProduct();
	
	public List<Product> findProductByCategory(String category);
	
	int findMemoryListCnt(String category);
	List<Product> findMemoryList(Pagination pagination, String category);
	//////////////////////////////////////////////////////////////////////////////////
	
	public String registerProduct(Product product);

	public String registerProduct2(Product product);
	
	public void registerUploadFile(Photo photo);

	public Product findProductByPcCode(String pcCode);

	public List<Photo> findProductImage(String pcCode);
	
	public Photo findProductImageBySavedFileName(String savedFileName);

	public void modifyProduct(Product product);

	public void deleteProductImage(String savedFileName);

	public void deleteProduct(String pcCode);

	public Photo findProductImageByPcCode(String pcCode);

	public List<Product> findCPU();

	public List<Product> findMainBoard();

	public List<Product> findVGA();
	
}
 