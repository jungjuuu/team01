package com.cream.team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberInquiryController {
	//123
	@RequestMapping(value= {"/memberinquiry"})
	public String main() {
		return "memberinquiry";
	}
	

}


