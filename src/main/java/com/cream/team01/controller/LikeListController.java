package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.LikeDAO;
import com.cream.team01.vo.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LikeListController {
	
	 @Autowired
	    private LikeDAO likeDAO;

	    @Autowired
	    private HttpSession session;
	
	// 좋아요 목록 조회
    @RequestMapping("/likelist")
    public ModelAndView getLikedProducts() {
        Integer memberNo = (Integer) session.getAttribute("memberNo");

        if (memberNo == null) {
            return new ModelAndView("redirect:/accountlogin");
        }

        List<ProductVO> likedProducts = likeDAO.getLikedProductsByMemberNo(memberNo);
        ModelAndView result = new ModelAndView("likelist");
        result.addObject("likedProducts", likedProducts);

        return result;
    }
	

}


