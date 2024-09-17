package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.MemberDAO;
import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.MemberVO;
import com.cream.team01.vo.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class BuyController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/buyproduct/{productNo}")
	public ModelAndView getBuyProduct(@PathVariable("productNo") int productNo) {
		
		int memberNo = (Integer)session.getAttribute("memberNo");
		
		MemberVO member = memberDAO.getMemberInfo(memberNo);
		
		ProductVO buyproduct = productDAO.getProductByNo(productNo);
		
		ModelAndView result = new ModelAndView("buyproduct"); 
		
		
		result.addObject("buyproduct", buyproduct);
		result.addObject("member", member);

		return result; 
		
	}
	
	
	
}
