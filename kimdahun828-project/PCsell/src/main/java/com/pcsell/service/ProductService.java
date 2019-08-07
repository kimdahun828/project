package com.pcsell.service;


import java.util.HashMap;
import java.util.List;

import com.pcsell.common.Pagination;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductService {


	List<Product> DramList();

	List<Photo> dramFileListByPcCode(String pcCode);

	List<Product> Dramdetail(String pcCode);

	List<Photo> dramDetailFileListByPcCode(Product product);

	String registerProduct(Product product);
	
	void registerUploadFile(Photo photo);

	List<Product> search(HashMap<String, Object> params);

	List<Photo> searchFileListByPcCode(HashMap<String, Object> params);

	int findMemoryListCnt(String category);
	List<Product> findMemoryList(Pagination pagination, String category);

}
 