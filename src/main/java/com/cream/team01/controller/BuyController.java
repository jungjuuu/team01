package com.cream.team01.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.BuyDAO;
import com.cream.team01.dao.CartDAO;
import com.cream.team01.dao.MemberDAO;
import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.CartVO;
import com.cream.team01.vo.MemberVO;
import com.cream.team01.vo.OrderVO;
import com.cream.team01.vo.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class BuyController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private BuyDAO buyDAO;
	
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	HttpSession session;

	// 결제페이지에 상품과 회원정보 가져오기
	@RequestMapping("/buyproduct/{productNo}")
	public ModelAndView getBuyProduct(@PathVariable("productNo") int productNo) {

		int memberNo = (Integer) session.getAttribute("memberNo");

		MemberVO member = memberDAO.getMemberInfo(memberNo);

		ProductVO buyproduct = productDAO.getProductByNo(productNo);

		ModelAndView result = new ModelAndView("buyproduct");

		result.addObject("buyproduct", buyproduct);
		result.addObject("member", member);

		return result;

	}

	// 결제했을 때 마이페이지 주문내역에 추가
	@RequestMapping("/addOrder")
	public ModelAndView AddOrderList(@RequestParam("productNo") int productNo,
			@RequestParam("productQuantity") int quantity, @RequestParam("orderPrice") int orderPrice) {

		int memberNo = (Integer) session.getAttribute("memberNo");

		// 주문 추가
		OrderVO order = new OrderVO();
		order.setMemberNo(memberNo);

		// 자동 증가된 order_no를 반환받음
		buyDAO.addOrder(order);
		int orderNo = order.getOrderNo(); // orderNo가 여기에서 설정됨

		// 주문 상세 추가
		OrderVO orderDetail = new OrderVO();
		orderDetail.setOrderQuantity(quantity);
		orderDetail.setOrderPrice(orderPrice);
		orderDetail.setOrderNo(orderNo);
		orderDetail.setProductNo(productNo);

		buyDAO.addOrderDetail(orderDetail);

		ModelAndView result = new ModelAndView("redirect:/order");

		return result;
	}

	@RequestMapping("/addOrderCart")
	public ModelAndView AddOrderCart(@RequestParam("productNo") List<Integer> productNos,
			@RequestParam("productQuantity") List<Integer> productQuantities,
			@RequestParam("productPrice") List<Integer> productPrices) {

		
		int memberNo = (Integer) session.getAttribute("memberNo");
		
		
		
		for (int i = 0; i < productNos.size(); i++) {
			
			// 주문 추가
			OrderVO order = new OrderVO();
			order.setMemberNo(memberNo);

			// 자동 증가된 order_no를 반환받음
			buyDAO.addOrder(order);
			int orderNo = order.getOrderNo(); // orderNo가 여기에서 설정됨

			// 주문 상세 추가
			OrderVO orderDetail = new OrderVO();
			orderDetail.setOrderQuantity(productQuantities.get(i));
			orderDetail.setOrderPrice(productPrices.get(i)*productQuantities.get(i));
			orderDetail.setOrderNo(orderNo);
			orderDetail.setProductNo(productNos.get(i));

			buyDAO.addOrderDetail(orderDetail);
			
			// 주문 후에 장바구니에서 주문상품 삭제
			CartVO cvo = new CartVO();
			cvo.setMemberNo(memberNo);
			cvo.setProductNo(productNos.get(i));
			
			cartDAO.deleteCartItems(cvo);
			
			
		}

		ModelAndView result = new ModelAndView("redirect:/order");

		
		return result;
	}

}
