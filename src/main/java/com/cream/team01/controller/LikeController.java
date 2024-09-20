package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.LikeDAO;
import com.cream.team01.vo.ProductVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeDAO likeDAO;

    @Autowired
    private HttpSession session;

    // 좋아요 클릭 기능 처리
    @PostMapping("/click")
    public String clickLike(@RequestParam("productNo") int productNo) {
        Integer memberNo = (Integer) session.getAttribute("memberNo");

        if (memberNo == null) {
            return "notLoggedIn";  
        }

        // 이미 좋아요를 눌렀는지 확인
        boolean isLiked = likeDAO.checkLike(productNo, memberNo);

        if (isLiked) {
            likeDAO.removeLike(productNo, memberNo); 
            return "removed";
        } else {
            likeDAO.addLike(productNo, memberNo);  
            return "added";
        }
    }

    // 좋아요 수 조회
    @PostMapping("/count")
    public int getLikesCount(@RequestParam("productNo") int productNo) {
        return likeDAO.getLikesCount(productNo);
    }

    
}
