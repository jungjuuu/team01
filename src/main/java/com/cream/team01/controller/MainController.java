package com.cream.team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	//123
	@RequestMapping(value= {"/", "/main"})
	public String main() {
		return "main";
	}

}


