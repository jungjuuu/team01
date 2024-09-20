package com.cream.team01.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.AccountDAO;
import com.cream.team01.dao.MemberDAO;
import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.AccountVO;
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
	
	@Autowired
	AccountDAO accountDAO;

	// 주문내역
	@RequestMapping("/order")
	public ModelAndView getOrderList() {

		int memberNo = (Integer) session.getAttribute("memberNo");
		
		MemberVO member = memberDAO.getMemberInfo(memberNo);

		List<OrderVO> orderList = memberDAO.getOrderListByMemberNo(memberNo);

		ModelAndView result = new ModelAndView("orderlist");

		result.addObject("member", member);
		result.addObject("orderList", orderList);

		return result;
	}

	// 회원 마이페이지
	@RequestMapping("/membermypage")
	public ModelAndView memberMyPageMain() {

		int memberNo = (Integer) session.getAttribute("memberNo");

		MemberVO member = memberDAO.getMemberInfo(memberNo);

		ModelAndView result = new ModelAndView("membermypage");

		result.addObject("member", member);

		return result;
	}

	@RequestMapping("/editmemberform")
	public ModelAndView editMemberForm() {

		int memberNo = (Integer) session.getAttribute("memberNo");

		ModelAndView result = new ModelAndView("/editmemberform");
		result.addObject("memberNo", memberNo);

		MemberVO member = memberDAO.getMemberInfo(memberNo);
		result.addObject("member", member);

		return result;
	}

	@PostMapping("/editmember")
	public String editMember(@ModelAttribute MemberVO mvo) {

		
		memberDAO.editMember(mvo);

		return "redirect:/membermypage";

	}
	
	@RequestMapping("/deletemember")
	public String deleteMember() {
		int memberNo = (Integer) session.getAttribute("memberNo");
		int accountNo = (Integer) session.getAttribute("accountNo");
		
		
		memberDAO.deleteMember(memberNo);
		memberDAO.deleteMemberAccount(accountNo);
		
		return "redirect:/main";
	}

}
