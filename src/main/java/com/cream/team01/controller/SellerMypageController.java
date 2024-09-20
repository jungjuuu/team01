package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.ProductDAO;
import com.cream.team01.dao.SellerDAO;
import com.cream.team01.vo.ProductVO;
import com.cream.team01.vo.SellerVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class SellerMypageController {
	
	  @Autowired
	    private ProductDAO productDAO;

	    @Autowired
	    private SellerDAO sellerDAO;
	    
		/*
		 * //123
		 * 
		 * @RequestMapping(value= {"/sellermypage"}) public String main() { return
		 * "sellermypage"; }
		 */
	
    
	
}


