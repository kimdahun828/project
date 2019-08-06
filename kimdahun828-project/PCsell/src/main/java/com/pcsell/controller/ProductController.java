package com.pcsell.controller;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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
			value="/productCategoryList",
			method=RequestMethod.GET)
	public String productCategoryList(String category, Model model) {
		
		List<Product> products = productService.findProductByCategory(category);
		
		for(Product product : products) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
		
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping(
			value="/productWrite",
			method=RequestMethod.POST)
	public String productWrite(MultipartHttpServletRequest req, Product product) {

		MultipartFile mf = req.getFile("productImage");
		boolean test = mf.isEmpty();
		
		if (test == false) {
			
			ServletContext application = req.getServletContext();
			String path = application.getRealPath("resources/img");
			
			String userFileName =  mf.getOriginalFilename();
			if (userFileName.contains("\\")) { // iexplore 野껋럩�뒭
				//C:\AAA\BBB\CCC.png -> CCC.png 
				userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
			}
			String savedFileName = Util.makeUniqueFileName(userFileName);

			try {
				mf.transferTo(new File(path, savedFileName)); //占쎈솁占쎌뵬 占쏙옙占쎌삢
				
				Photo photo = new Photo();
				photo.setUserFileName(userFileName);
				photo.setSavedFileName(savedFileName);
				ArrayList<Photo> files = new ArrayList<Photo>();
				files.add(photo);
				product.setFiles(files);
				
				productService.registerProduct(product);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		} else if(test != false) {
			
			productService.registerProduct2(product);
			
			return "redirect:/productList";
		}

		return "redirect:/productList";
	}
	
	@RequestMapping(value="/productUpdate/{pcCode}", method=RequestMethod.GET)
	public String productUpdateForm(@PathVariable String pcCode, Model model) {
		
		Product product = productService.findProductByPcCode(pcCode);
		if(product == null) {
			return "redirect:/productList";
		}
		
		List<Photo> photo = productService.findProductImage(pcCode);
		product.setFiles((List<Photo>) photo);
		
		model.addAttribute("product", product);
		
		return "productUpdate";
	}
	
	@RequestMapping(
			path="/productUpdate",
			method=RequestMethod.POST)
	public String productUpdate(MultipartHttpServletRequest req, Product product) {
		
		MultipartFile mf = req.getFile("productImage");
		boolean test = mf.isEmpty();
		
		if (test != true) {
			
			ServletContext application = req.getServletContext();
			String path = application.getRealPath("resources/img");
			
			String userFileName =  mf.getOriginalFilename();
			if (userFileName.contains("\\")) { // iexplore 野껋럩�뒭
				//C:\AAA\BBB\CCC.png -> CCC.png 
				userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
			}
			String savedFileName = Util.makeUniqueFileName(userFileName);

			try {
				mf.transferTo(new File(path, savedFileName)); //占쎈솁占쎌뵬 占쏙옙占쎌삢
				
				Photo photo = new Photo();
				photo.setUserFileName(userFileName);
				photo.setSavedFileName(savedFileName);
				photo.setPcCode(product.getPcCode());
				productService.registerUploadFile(photo);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		} else if (test != false) {
			productService.modifyProduct(product);
			return "redirect:/detail/" + product.getPcCode();
		}
	
		return "redirect:/detail/" + product.getPcCode();
	}
	
	@RequestMapping(path="/img/{fileName}", method = RequestMethod.GET)
	public String detailImage(@PathVariable String fileName, Model model) {
		
		Photo productImage = productService.findProductImageBySavedFileName(fileName);
		
		model.addAttribute("productImage", productImage);		
		
		return "detail";
	}
	
	@RequestMapping(value="/productDelete/{pcCode}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable String pcCode) {
		
		
		File file = new File(pcCode);
		if (file.exists()) {
			file.delete();
		}
		
		productService.deleteProductImage(pcCode);
		
		productService.deleteProduct(pcCode);
		
		return"redirect:/productList";
	}
	
	@RequestMapping(path="/deleteImage", method = RequestMethod.GET)
	public String deleteFile(String pcCode, String savedFileName, Model model) {
		
		Photo photo = productService.findProductImageByPcCode(pcCode);
		
		File file = new File(photo.getPcCode());
		if (file.exists()) {
			file.delete();
		}
		
		productService.deleteProductImage(pcCode);
		
		return "redirect:/productUpdate/" + pcCode;
	}
}
