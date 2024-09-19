package com.cream.team01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.BoardDAO;
import com.cream.team01.vo.BoardVO;
import com.cream.team01.vo.MemberVO;
import com.cream.team01.vo.SellerVO;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberInquiryWriteController {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private HttpSession session;
	
	
	
	@RequestMapping(value = {"/memberinquirywrite"})
	public ModelAndView getForm() {
		ModelAndView result = new ModelAndView("/memberinquirywrite");
		return result; 
	}
	
	
	
	@RequestMapping("/addmemberinquirywrite")
	public String addMemberInquiryWriteForm(BoardVO board, HttpSession session) {
		
		Integer memberNo = (Integer) session.getAttribute("memberNo");
		Integer productNo = (Integer) session.getAttribute("productNo");
		
		board.setMemberNo(memberNo);
		board.setProductNo(productNo);
		    
		boardDAO.addMemberInquiryWrite(board);

		return "/memberinquirywrite";
}
	

}


