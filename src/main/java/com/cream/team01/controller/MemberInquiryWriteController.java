package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.BoardDAO;
import com.cream.team01.vo.BoardVO;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberInquiryWriteController {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private HttpSession session;
	
	// 문의 폼
    @GetMapping("/inquiry/{productNo}")
    public ModelAndView inquiryForm(@PathVariable("productNo") int productNo) {
        ModelAndView result = new ModelAndView("memberinquirywrite");
        result.addObject("productNo", productNo); 
        return result;
    }

    // 문의 등록 처리
	@PostMapping("/addmemberinquirywrite")
	public String addMemberInquiryWriteForm(BoardVO board, HttpSession session) {
		Integer memberNo = (Integer) session.getAttribute("memberNo");
		board.setMemberNo(memberNo);
		boardDAO.addMemberInquiryWrite(board);
		return "redirect:/memberinquiry"; 
	}
	

}


