package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.ProductVO;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;

	// 카테고리별 상품 목록을 조회
	@RequestMapping("/category/{categoryNo}")
	public ModelAndView getProductsByCategory(@PathVariable("categoryNo") int categoryNo) {
		List<ProductVO> products = productDAO.getProductsByCategory(categoryNo);
		ModelAndView result = new ModelAndView("products"); 
		result.addObject("products", products); 

		return result; 
	}

	// 상품 상세 페이지를 조회
	@RequestMapping("/detail/{productNo}")
	public ModelAndView getProductDetail(@PathVariable("productNo") int productNo) {
		ProductVO product = productDAO.getProductByNo(productNo);
		ModelAndView result = new ModelAndView("productDetail"); 
		result.addObject("product", product); 

		return result; 
	}
}