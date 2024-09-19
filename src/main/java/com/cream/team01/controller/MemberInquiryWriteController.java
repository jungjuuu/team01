package com.cream.team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberInquiryWriteController {
	//123
	@RequestMapping(value= {"/memberinquirywrite"})
	public String main() {
		return "memberinquirywrite";
	}
	

}


