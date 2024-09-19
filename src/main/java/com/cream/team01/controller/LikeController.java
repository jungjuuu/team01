package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cream.team01.dao.LikeDAO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/like")
public class LikeController {

	@Autowired
    private LikeDAO likeDAO;
	
	@Autowired
	private HttpSession session;

    // 좋아요 기능 처리
    @PostMapping("/click")
    @ResponseBody
    public String clickLike(@RequestParam("productNo") int productNo) {
        Integer memberNo = (Integer) session.getAttribute("memberNo");

        // 사용자가 로그인 되어 있지 않은 경우
        if (memberNo == null) {
            return "notLoggedIn";
        }

        // 좋아요 여부 확인
        boolean isLiked = likeDAO.checkLike(productNo, memberNo);

        if (isLiked) {
            likeDAO.removeLike(productNo, memberNo);
            return "removed";
        } else {
            likeDAO.addLike(productNo, memberNo);
            return "added";
        }
    }

    // 상품의 좋아요 수 조회
    @PostMapping("/count")
    @ResponseBody
    public int getLikesCount(@RequestParam("productNo") int productNo) {
        return likeDAO.getLikesCount(productNo);
    }
}
