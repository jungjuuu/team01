package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.CategoryDAO;
import com.cream.team01.dao.LikeDAO;
import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.CategoryVO;
import com.cream.team01.vo.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private LikeDAO likeDAO;
	
	@Autowired
	HttpSession session;

	// 카테고리별 상품 목록을 조회
	@RequestMapping("/category/{categoryNo}")
	public ModelAndView getProductsByCategory(@PathVariable("categoryNo") int categoryNo,
			@RequestParam(value = "sort", required = false) String sort) {
		Integer memberNo = (Integer) session.getAttribute("memberNo");
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

		if (memberNo != null) {
			for (ProductVO product : products) {
				boolean isLiked = likeDAO.checkLike(product.getProductNo(), memberNo);
				product.setLiked(isLiked); // 좋아요 상태를 ProductVO에 추가
			}
		}

		// 각 상품에 대해 좋아요 수를 추가
		for (ProductVO product : products) {
			int likesCount = likeDAO.getLikesCount(product.getProductNo());
			product.setLikesCount(likesCount); // 좋아요 수를 ProductVO에 추가
		}

		ModelAndView result = new ModelAndView("products");
		result.addObject("sort", sort);
		result.addObject("products", products);
		result.addObject("category", category);
		return result;
	}

	// 상품 상세 페이지를 조회
	@RequestMapping("/detail/{productNo}")
	public ModelAndView getProductDetail(@PathVariable("productNo") int productNo) {
		Integer memberNo = (Integer) session.getAttribute("memberNo");
		ProductVO product = productDAO.getProductByNo(productNo);
		if (memberNo != null) {
			boolean isLiked = likeDAO.checkLike(product.getProductNo(), memberNo);
			product.setLiked(isLiked);
		}
		ModelAndView result = new ModelAndView("productDetail");
		result.addObject("product", product);

		return result;
	}

}