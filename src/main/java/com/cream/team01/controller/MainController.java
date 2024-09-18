package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.ProductVO;

@Controller
public class MainController {
	
	@Autowired
	ProductDAO productDAO;
	
	//123
	@RequestMapping(value= {"/", "/main"})
	public ModelAndView main() {
		List<ProductVO> newProducts = productDAO.getNewProducts();
		 ModelAndView result = new ModelAndView("main");  
	        result.addObject("newProducts", newProducts);  
	        return result;
		
	}
	

}


