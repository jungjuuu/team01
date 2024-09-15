package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.ProductDAO;
import com.cream.team01.dao.SellerDAO;
import com.cream.team01.vo.ProductVO;
import com.cream.team01.vo.SellerVO;

@Controller
@RequestMapping("/seller/products")
public class SellerProductController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private SellerDAO sellerDAO;

	// 판매자의 상품 목록 조회 result

	@RequestMapping("/list")
	public ModelAndView sellerProductList() {
		// (@PathVariable("sellerNo") int sellerNo)
		// sellerNo이 1이라는 가정 하에 상품 목록 조회
		int sellerNo = 1;

		SellerVO seller = sellerDAO.getSellerByNo(sellerNo);

		List<ProductVO> products = productDAO.getProductsBySeller(sellerNo);

		ModelAndView result = new ModelAndView("sellerProductList"); // 상품 목록 뷰
		result.addObject("seller", seller);
		result.addObject("products", products);
		return result;
	}

	// 상품 등록 폼
	@RequestMapping("/add")
	public ModelAndView addProductForm() {
		ModelAndView result = new ModelAndView("addProduct_form");
		result.addObject("product", new ProductVO()); // 빈 폼을 위한 객체 전달
		return result;
	}

	// 상품 등록 처리
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute ProductVO product) {
		// sellerNo을 1로 가정하고 상품 등록
		product.setSellerNo(1); // 로그인 기능이 없으므로 sellerNo을 1로 하드코딩
		productDAO.addProduct(product);
		return "redirect:/seller/products/list";
	}

	// 상품 수정 폼
	@RequestMapping("/edit/{productNo}")
	public ModelAndView editProductForm(@PathVariable("productNo") int productNo) {
		ProductVO product = productDAO.getProductByNo(productNo);
		ModelAndView result = new ModelAndView("editProduct_form");
		result.addObject("product", product);
		return result;
	}

	// 상품 수정 처리
	@RequestMapping(value = "/edit/{productNo}", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute ProductVO product) {
		productDAO.updateProduct(product);
		return "redirect:/seller/products/list";
	}

	// 상품 삭제 처리
	@RequestMapping("/delete/{productNo}")
	public String deleteProduct(@PathVariable("productNo") int productNo) {
		productDAO.deleteProduct(productNo); // DAO에서 해당 상품 삭제 처리
		return "redirect:/seller/products/list"; // 삭제 후 상품 목록으로 리다이렉트
	}
}
