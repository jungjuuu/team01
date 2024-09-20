package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@PostMapping("/addCartItem")
	@ResponseBody
	public String addCartItem(@RequestParam("productNo") int productNo) {

		Integer memberNo = (Integer) session.getAttribute("memberNo");
		if (memberNo == null) {
			return "error";
		}

		CartVO checkCart = cartDAO.getCartByMemberNo(memberNo);

		int cartNo;
		// 장바구니 추가, 장바구니가 없으면 새로 생성

		if (checkCart == null) {

			CartVO cart = new CartVO();
			cart.setMemberNo(memberNo);
			cartDAO.addCartItem(cart);
			cartNo = cart.getCartNo();
		} else {
			
			// 기존 장바구니 있으면 해당 cartNo 설정
			cartNo = checkCart.getCartNo(); 
			
		}


		// 장바구니 상세 추가
		CartVO cartDetail = new CartVO();
		cartDetail.setProductNo(productNo);
		cartDetail.setCartNo(cartNo);

		cartDAO.addCartDetail(cartDetail);

		return "success";
	}

}
