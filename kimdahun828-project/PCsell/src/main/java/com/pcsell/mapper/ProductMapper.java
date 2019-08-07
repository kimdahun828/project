package com.pcsell.mapper;

import java.util.HashMap;
import java.util.List;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductMapper {

	void insertProduct(Product product);
	
	void insertProductImage(Photo photo);

	List<Product> dramList();
	List<Photo> dramFileList(String pcCode);

	List<Product> dramDetailList(String pcCode);
	List<Photo> dramDetailFileListByPcCode(Product product);

	List<Product> search(HashMap<String, Object> params);

	List<Photo> searchFileListByPcCode(HashMap<String, Object> params);

	int findMemoryListCnt(HashMap<String, Object> param);

	List<Product> findMemoryList(HashMap<String, Object> params);
}
 