package com.pcsell.repository;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;
import com.pcsell.mapper.ProductMapper;
import com.pcsell.repository.ProductRepository;

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
	
}
