package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cream.team01.dao.BoardDAO;
import com.cream.team01.vo.BoardVO;

import org.springframework.ui.Model;

@Controller
public class MemberInquiryController {
	
	@Autowired
	 private BoardDAO boardDAO;

	// 회원 문의 리스트 조회
	 @RequestMapping(value = {"/memberinquiry"})
	    public String main(Model model) {
	        // 모든 문의 목록을 가져와서 모델에 추가
	        List<BoardVO> inquiryList = boardDAO.getMemberInquiries();
	        model.addAttribute("inquiryList", inquiryList);
	        return "memberinquiry";
	    }

}


