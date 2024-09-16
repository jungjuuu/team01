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

@Controller
public class RegisterController {
	
	@Autowired
    private RegisterDAO registerDAO;

	@RequestMapping("/memberregister")
    public ModelAndView addMemberRegisterForm( 
    		@ModelAttribute AccountVO account, // 폼에서 넘어온 account 데이터를 AccountVO 객체에 매핑
            @ModelAttribute MemberVO member){ 
		 registerDAO.createAccount(account);  // 계정 정보를 데이터베이스에 저장
	        registerDAO.createMember(member);
        ModelAndView result = new ModelAndView("/memberregister"); 
        return result;
    }

	@RequestMapping("/sellerregister")
    public ModelAndView showSellerRegisterForm() { 
        ModelAndView result = new ModelAndView("/sellerregister"); 
        return result;
    }
	
	
	
}


