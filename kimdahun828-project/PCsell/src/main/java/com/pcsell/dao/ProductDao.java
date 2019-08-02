package com.pcsell.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;
import com.pcsell.mapper.ProductMapper;

public class ProductDao {

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
	
	public String insertProduct(Product product) {
		
		productMapper.insertProduct(product);
		
		return product.getPcCode();
	}
	
	public void insertProductImage(Photo photo) {
		
		productMapper.insertProductImage(photo);
		
		return;
		
	}
	
}
