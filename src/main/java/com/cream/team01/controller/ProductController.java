package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.CategoryDAO;
import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.CategoryVO;
import com.cream.team01.vo.ProductVO;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	 // 카테고리별 상품 목록을 조회
    @RequestMapping("/category/{categoryNo}")
    public ModelAndView getProductsByCategory(@PathVariable("categoryNo") int categoryNo, 
            @RequestParam(value = "sort", required = false) String sort) {
    	List<ProductVO> products;
    	// null 체크
        if (sort == null || sort.isEmpty()) {
            products = productDAO.getProductsByCategory(categoryNo);
        } else if (sort.equals("highPrice")) {
            products = productDAO.getProductsByCategorySortedByHighPrice(categoryNo);
        } else if (sort.equals("lowPrice")) {
            products = productDAO.getProductsByCategorySortedByLowPrice(categoryNo);
        } else if (sort.equals("likes")) {
            products = productDAO.getProductsByCategorySortedByLikes(categoryNo);
        } else {
            products = productDAO.getProductsByCategory(categoryNo);
        }
        CategoryVO category = categoryDAO.getCategoryNameByNo(categoryNo); 
        
        
        ModelAndView result = new ModelAndView("products");
        result.addObject("sort", sort);
        result.addObject("products", products);
        result.addObject("category", category); 
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