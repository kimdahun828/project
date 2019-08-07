package com.pcsell.controller;

import java.io.File;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pcsell.common.Pagination;
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
		
		int pageSize = 9;
		int currentPage = 1;
		
		int from = (currentPage - 1) * pageSize + 1;
		int to = from + pageSize;
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("from", from);
		params.put("to", to);
		
		List<Product> products = productService.findProductByCategory(category);
		
		for(Product product : products) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}
		
		model.addAttribute("products", products);
		
		int productsCount = productService.findProductCount();
		model.addAttribute("productsCount", productsCount);
		
		return "productCategoryList";
	}
	
	@RequestMapping(
			value="/productWrite",
			method=RequestMethod.GET)
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
	
	@RequestMapping(value = "/dram/{pcCode}", method = RequestMethod.GET)
	public String dramDetail(@PathVariable String pcCode, Model model) { //Dram Detail

		List<Product> dramDetails = productService.Dramdetail(pcCode);		
		for (Product dramDetail : dramDetails) {
			List<Photo> files = productService.dramDetailFileListByPcCode(dramDetails.get(0));
			dramDetail.setFiles(files);
		}
		
		model.addAttribute("dramdetail", dramDetails);

		return "dramdetail";
	}	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(name="name") String name, @RequestParam(name="category") String category, Model model) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("category", category);
		
		List<Product> search = productService.search(params);
		
		for (Product product : search) {
			List<Photo> photo = productService.findProductImage(product.getPcCode());
			product.setFiles(photo);
		}

		model.addAttribute("search", search);
		return "searchproductList"; 
	}
	
	@RequestMapping(value = "/memorylist", method = RequestMethod.GET)
	public String list(Model model, @RequestParam(required = false, defaultValue = "1") int page
						, @RequestParam(required = false, defaultValue = "1") int range){
		try {
			String category = "RAM";
		
			// 전체 게시글 개수 
			int listCnt = productService.findMemoryListCnt(category);

			// Pagination 객체생성
			Pagination pagination = new Pagination();
			pagination.pageInfo(page, range, listCnt);

			model.addAttribute("pagination", pagination);

			
	        // 전체리스트
			List<Product> products = productService.findMemoryList(pagination,category);
			if(products ==null) {
				return "redirect:/";
			}
			
			for (Product product : products) {
				List<Photo> files = productService.dramFileListByPcCode(product.getPcCode());
				product.setFiles(files);
			}
			
			model.addAttribute("product", products);
			model.addAttribute("listCnt", listCnt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "memory";
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
	
	@RequestMapping(value = "/productSearch", method = RequestMethod.GET)
	public String productSearch(String search, Model model, Product product) {
		
		int pageSize = 9;
		int currentPage = 1;
		
		int from = (currentPage - 1) * pageSize + 1;
		int to = from + pageSize;
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("from", from);
		params.put("to", to);
		
		List<Product> searchProduct = productService.searchProductByName(search);
		
		for (Product product1 : searchProduct) {
			List<Photo> photo = productService.findProductImage(product1.getPcCode());
			product1.setFiles(photo);
		}
		
		int productsCount = productService.findProductCount();
		model.addAttribute("productsCount", productsCount);
		
		model.addAttribute("searchProduct", searchProduct);
		model.addAttribute("search", search);
		
		return "/productSearchList";
	}
	
}
