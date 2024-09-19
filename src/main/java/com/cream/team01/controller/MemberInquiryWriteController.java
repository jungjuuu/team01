package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.BoardDAO;
import com.cream.team01.vo.BoardVO;

@Controller
public class MemberInquiryWriteController {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping("/memberinquirywrite")
	public ModelAndView addMemberInquiryWriteForm(
			@ModelAttribute BoardVO board) {
		
		boardDAO.creatememberInquriyWrite(board);
		ModelAndView result = new ModelAndView("/creatememberInquriyWrite"); 
        return result;
	}
	

}


