package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.CartDAO;
import com.cream.team01.dao.MemberDAO;
import com.cream.team01.vo.CartVO;
import com.cream.team01.vo.MemberVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	HttpSession session;

	// 장바구니페이지에 상품과 회원정보 가져오기
	@RequestMapping("/cart")
	public ModelAndView getCartList() {


		int memberNo = (Integer) session.getAttribute("memberNo");
		
		MemberVO member = memberDAO.getMemberInfo(memberNo);
		
		
		List<CartVO> cartItems = cartDAO.getCartItems(member);

		ModelAndView result = new ModelAndView("cart");
		
		result.addObject("member", member);
		result.addObject("cartItems", cartItems);

		return result;

	}
	
	// 장바구니버튼 누를 시 장바구니 리스트에 추가
	public ModelAndView addCartItem() {
		return null;
	}

}
