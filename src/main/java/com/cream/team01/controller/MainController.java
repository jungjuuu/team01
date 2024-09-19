package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.LikeDAO;
import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

   @Autowired
   private ProductDAO productDAO;
   @Autowired
   private LikeDAO likeDAO;
   @Autowired
   HttpSession session;

   // 123
   @RequestMapping(value = { "/", "/main" })
   public ModelAndView main() {
      Integer memberNo = (Integer) session.getAttribute("memberNo");
      List<ProductVO> newProducts = productDAO.getNewProducts();
      List<ProductVO> popularProducts = productDAO.getPopularProducts();

      // 인기 상품의 좋아요 상태 및 좋아요 수 처리
      for (ProductVO product : popularProducts) {
         if (memberNo != null) {
            boolean isLiked = likeDAO.checkLike(product.getProductNo(), memberNo);
            product.setLiked(isLiked);
         }
         int likesCount = likeDAO.getLikesCount(product.getProductNo());
         product.setLikesCount(likesCount);
      }

      // 신규 상품의 좋아요 상태 및 좋아요 수 처리
      for (ProductVO product : newProducts) {
         if (memberNo != null) {
            boolean isLiked = likeDAO.checkLike(product.getProductNo(), memberNo);
            product.setLiked(isLiked);
         }
         int likesCount = likeDAO.getLikesCount(product.getProductNo());
         product.setLikesCount(likesCount);
      }

      ModelAndView result = new ModelAndView("main");
      result.addObject("newProducts", newProducts);
      result.addObject("popularProducts", popularProducts);
      return result;

   }

}
