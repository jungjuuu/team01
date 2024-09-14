package com.cream.team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuyController {

	@RequestMapping(value = {"/buy"})
	public ModelAndView getBuyProduct() {
		ModelAndView result = new ModelAndView("/buyproduct"); 
		return result;
	}
	
}
