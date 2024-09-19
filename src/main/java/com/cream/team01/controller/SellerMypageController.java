package com.cream.team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SellerMypageController {
	//123
	@RequestMapping(value= {"/sellermypage"})
	public String main() {
		return "sellermypage";
	}
	

}


