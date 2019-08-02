package com.pcsell.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pcsell.dao.CartDao;
import com.pcsell.vo.Upload;
import com.pcsell.vo.UploadFile;
 
@Service("cartService")
public class CartServiceImpl implements CartService {
	

	private CartDao cartDao;	
	public CartDao getCartDao() {
		return cartDao;
	}
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	@Override
	public ArrayList<Upload> count() { // list 총 권수
		ArrayList<Upload> counts = cartDao.count();
		return counts;
	}
	@Override
	public List<Upload> findCheckList() {
		ArrayList<Upload> checkList = cartDao.findCheckList();
		return checkList;
	}
	

}
