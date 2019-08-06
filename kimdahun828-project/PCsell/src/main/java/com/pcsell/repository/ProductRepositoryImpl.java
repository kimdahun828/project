package com.pcsell.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

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
	 
}
