package com.pcsell.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pcsell.common.Pagination;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public interface ProductRepository {
	
	public String insertProduct(Product product);
	
	void insertProductImage(Photo photo);

	public ArrayList<Product> DramList();

	public ArrayList<Photo> dramFileList(String pcCode);

	public ArrayList<Product> DramDetail(String pcCode);

	public ArrayList<Photo> dramDetailFileListByPcCode(Product product);

	public ArrayList<Product> search(HashMap<String, Object> params);

	public ArrayList<Photo> searchFileListByPcCode(HashMap<String, Object> params);

	public List<Product> findMemoryList(Pagination pagination, String category);

	public int findMemoryListCnt(String category);
	
}

