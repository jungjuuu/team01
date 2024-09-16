package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.ProductDAO;
import com.cream.team01.dao.RegisterDAO;
import com.cream.team01.vo.AccountVO;
import com.cream.team01.vo.MemberVO;
import com.cream.team01.vo.SellerVO;

@Controller
public class RegisterController {
	
	@Autowired
    private RegisterDAO registerDAO;
	
	// 멤버 회원가입
	@RequestMapping("/memberregister")
    public ModelAndView addMemberRegisterForm( 
    		@ModelAttribute AccountVO account, 
            @ModelAttribute MemberVO member){ 
		
		 registerDAO.createAccount(account);  
		 member.setAccountNo(account.getAccountNo());   
		 registerDAO.createMember(member);
		 
        ModelAndView result = new ModelAndView("/memberregister"); 
        return result;
    }

	// 브랜드 회원가입
	@RequestMapping("/sellerregister")
    public ModelAndView showSellerRegisterForm( 
    		@ModelAttribute AccountVO account, 
            @ModelAttribute SellerVO seller){ 
		
		 registerDAO.createAccount(account);  
		 seller.setAccountNo(account.getAccountNo());   
		 registerDAO.createBrand(seller);
		 
        ModelAndView result = new ModelAndView("/sellerregister"); 
        return result;
    }

	
	
	
}

