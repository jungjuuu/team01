package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.MemberDAO;
import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.MemberVO;
import com.cream.team01.vo.OrderVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	HttpSession session;
	
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	
	//주문내역
	@RequestMapping("/order")
	public ModelAndView getOrderList() {
		
		int memberNo = (Integer)session.getAttribute("memberNo");
		
		MemberVO member = memberDAO.getMemberInfo(memberNo);
		
		List<OrderVO> orderList = memberDAO.getOrderListByMemberNo(memberNo);
		
		ModelAndView result = new ModelAndView("orderlist"); 
		
		result.addObject("member", member);
		result.addObject("orderList", orderList);
		
		return result;
	}
}
