package com.cream.team01.controller;

import java.io.IOException;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.SellerDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class SellerLoginController {
	
	//log 남기기, 출력 -> slf4j
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	 @Autowired SellerDAO dao;
	 

	@RequestMapping("/sellerlogin.do") 
	public ModelAndView getForm() {
		ModelAndView result = new ModelAndView("/memberlogin");// 페이지로 포워딩
		return result;
	}
}
	
