package com.cream.team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@RequestMapping(value= {"/main.do"})
	public String main() {
		System.out.println("");
		return "main";
	}
	
	//login : 인터셉트
	@RequestMapping("/sellerlogin.do")
	public String login(String accountId, String accountPassword, HttpSession session) {
		String page="login_form.do";
		if(accountId.equals(accountId) && accountPassword.equals(accountPassword)) {
			session.setAttribute("accountId", accountId);
			session.setAttribute("userPassword", accountPassword);
			
			page="main.do";
		}
		return "redirect:/" + page;		
	}
	
	//logout
	@RequestMapping("/logout.do")
		public String logout(HttpSession session) {
		session.setAttribute("accountId",null);
	return "redirect:/sellerlogin.do";
	}
}


