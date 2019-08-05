package com.pcsell.controller;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pcsell.service.ProductService;
import com.pcsell.util.Util;
import com.pcsell.vo.Photo;
import com.pcsell.vo.Product;

@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	
	@RequestMapping(
			value="/productWrite",
			method=RequestMethod.POST)
	public String productWrite(MultipartHttpServletRequest req, Product product) {

		MultipartFile mf = req.getFile("productImage");
		if (mf != null) {
			
			ServletContext application = req.getServletContext();
			String path = application.getRealPath("/upload-files");
			
			String userFileName =  mf.getOriginalFilename();
			if (userFileName.contains("\\")) { // iexplore 寃쎌슦
				//C:\AAA\BBB\CCC.png -> CCC.png 
				userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
			}
			String savedFileName = Util.makeUniqueFileName(userFileName);

			try {
				mf.transferTo(new File(path, savedFileName)); //�뙆�씪 ���옣
				
				Photo photo = new Photo();
				photo.setUserFileName(userFileName);
				photo.setSavedFileName(savedFileName);
				ArrayList<Photo> files = new ArrayList<Photo>();
				files.add(photo);
				product.setFiles(files);
				
				//�뜲�씠�꽣 ���옣
				productService.registerProduct(product);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}
	
		return "redirect:/productList";
	}
	
	
}
