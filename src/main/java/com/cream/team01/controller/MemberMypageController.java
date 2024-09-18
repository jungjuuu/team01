package com.cream.team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMypageController {
	//123
	@RequestMapping(value= {"/membermypage"})
	public String main() {
		return "membermypage";
	}
	

}


