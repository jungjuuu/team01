package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.ProductDAO;
import com.cream.team01.vo.ProductVO;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    // 카테고리별 상품 목록을 보여주는 메서드 (ModelAndView 사용)
    @RequestMapping("/category/{categoryNo}")
    public ModelAndView getProductsByCategory(@PathVariable("categoryNo") int categoryNo) {
        // DAO를 통해 해당 카테고리의 상품 목록을 가져옴
        List<ProductVO> products = productDAO.getProductsByCategory(categoryNo);

        // ModelAndView 객체 생성 및 데이터 추가
        ModelAndView mav = new ModelAndView("products"); // products.html 뷰 지정
        mav.addObject("products", products); // 상품 리스트를 모델에 추가

        return mav; // ModelAndView 반환
    }
}