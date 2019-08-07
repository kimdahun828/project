package com.pcsell.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pcsell.common.Pagination;
import com.pcsell.mapper.ProductMapper;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

public class ProductRepositoryImpl implements ProductRepository {

	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private SqlSessionTemplate sessionTemplate;
	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	private ProductMapper productMapper;

	public ProductMapper getProductMapper() {
		return productMapper;
	}
	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	} 
	
	@Override
	public ArrayList<Product> DramList() {
		List<Product> dramList = productMapper.dramList();
		return (ArrayList<Product>)dramList;
	}

	@Override
	public ArrayList<Photo> dramFileList(String pcCode) {
		List<Photo> dramFileList = productMapper.dramFileList(pcCode);
		return (ArrayList<Photo>)dramFileList;
	}
	@Override
	public ArrayList<Product> DramDetail(String pcCode) {
		List<Product> dramDetailList = productMapper.dramDetailList(pcCode);
		return (ArrayList<Product>)dramDetailList;
	}
	@Override
	public ArrayList<Photo> dramDetailFileListByPcCode(Product product) {
		List<Photo> dramDetailFileList = productMapper.dramDetailFileListByPcCode(product);
		return (ArrayList<Photo>)dramDetailFileList;
	}
	@Override
	public ArrayList<Product> search(HashMap<String, Object> params) {
		List<Product> search = productMapper.search(params);
		return (ArrayList<Product>)search;
	}
	@Override
	public ArrayList<Photo> searchFileListByPcCode(HashMap<String, Object> params) {
		List<Photo> searchFileListByPcCode = productMapper.searchFileListByPcCode(params);
		return (ArrayList<Photo>)searchFileListByPcCode;
	}
	@Override
	public List<Product> findMemoryList(Pagination pagination, String category) {
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("category", category);
		params.put("startList", pagination.getStartList());
		params.put("endList", pagination.getEndList());
		
		List<Product> products = productMapper.findMemoryList(params);
		return products;
	}
	@Override
	public int findMemoryListCnt(String category) {
		HashMap<String,Object> param = new HashMap<String, Object>();
		param.put("category", category);
		int memoryCnt = productMapper.findMemoryListCnt(param);
		return memoryCnt;
	}
	
	@Override
	public List<Product> selectProduct() {
		
		List<Product> products = productMapper.selectProduct();
		
		return products;
	}
	
	@Override
	public List<Product> selectProductByCategory(String category) {
		
		List<Product> products = productMapper.selectProductByCategory(category);
		
		return products;
	}
	
	@Override
	public String insertProduct(Product product) {
		
		productMapper.insertProduct(product);
		
		return product.getPcCode();
	}
	
	@Override
	public void insertProductImage(Photo photo) {
		
		productMapper.insertProductImage(photo);
		
		return;
		
	}
	
	@Override
	public Product selectProductByPcCode(String pcCode) {
		
		Product product = productMapper.selectProductByPcCode(pcCode);
		
		return product;
	}
	
	@Override
	public List<Photo> selectProductImageByPcCode(String pcCode) {
		
		List<Photo> photo = productMapper.selectProductImageByPcCode(pcCode);
		
		return (ArrayList<Photo>) photo;
	}
	
	@Override
	public Photo selectProductImageBySavedFileName(String fileName) {
		
		Photo productImage = productMapper.selectProductImageBySavedFileName(fileName);
		
		return productImage;
	}
	
	@Override
	public void updateProduct(Product product) {
	
		productMapper.updateProduct(product);
		
	}
	
	@Override
	public void deleteProductImage(String savedFileName) {
	
		productMapper.deleteProductImage(savedFileName);
		
	}
	
	@Override
	public void deleteProduct(String pcCode) {
		
		productMapper.deleteProduct(pcCode);
		
	}
	
	@Override
	public Photo findProductImageByPcCode(String pcCode) {
		
		Photo productImage = productMapper.findProductImageByPcCode(pcCode);
		
		return productImage;
	}
	
	@Override
	public List<Product> selectCPU() {
	
		List<Product> cpu = productMapper.selectCPU();
		
		return cpu;
	}
	
	@Override
	public List<Product> selectMainBoard() {
		
		List<Product> mainBoard = productMapper.selectMainBoard();
		
		return mainBoard;
	}
	
	@Override
	public List<Product> selectVGA() {

		List<Product> vga = productMapper.selectVGA();
		
		return vga;
	}

	@Override
	public int selectProductCount() {
		
		return productMapper.selectProductCount();
	}
	@Override
	public List<Product> selectProductWithPaging(HashMap<String, Object> params) {
		
		List<Product> products = 
				productMapper.selectProductWithPaging(params);
		
		return products;
	}
	@Override
	public List<Product> searchProductByName(String search) {

		List<Product> searchProduct = productMapper.searchProductByName(search);
		
		return searchProduct;
	}
	
}
