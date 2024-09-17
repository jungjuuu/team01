package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.ProductDAO;
import com.cream.team01.dao.SellerDAO;
import com.cream.team01.vo.ProductVO;
import com.cream.team01.vo.SellerVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/seller/products")
public class SellerProductController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private SellerDAO sellerDAO;

    // 판매자의 상품 목록 조회
    @RequestMapping("/list")
    public ModelAndView sellerProductList(HttpSession session) {
        Integer sellerNo = (Integer) session.getAttribute("sellerNo");  // 세션에서 sellerNo 가져오기

        if (sellerNo == null) {
            return new ModelAndView("redirect:/accountlogin");  
        }

        SellerVO seller = sellerDAO.getSellerByNo(sellerNo);
        List<ProductVO> products = productDAO.getProductsBySeller(sellerNo);

        ModelAndView result = new ModelAndView("sellerProductList");
        result.addObject("seller", seller);
        result.addObject("products", products);
        return result;
    }

    // 상품 등록 폼
    @RequestMapping("/add")
    public ModelAndView addProductForm(HttpSession session) {
        Integer sellerNo = (Integer) session.getAttribute("sellerNo");

        if (sellerNo == null) {
            return new ModelAndView("redirect:/accountlogin");  
        }

        ModelAndView result = new ModelAndView("addProduct_form");
        result.addObject("product", new ProductVO());  // 빈 폼을 위한 객체 전달
        return result;
    }

    // 상품 등록 처리
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute ProductVO product, HttpSession session) {
        Integer sellerNo = (Integer) session.getAttribute("sellerNo");

        if (sellerNo == null) {
            return "redirect:/accountlogin";  
        }

        product.setSellerNo(sellerNo);  
        productDAO.addProduct(product);
        return "redirect:/seller/products/list";
    }

    // 상품 수정 폼
    @RequestMapping("/edit/{productNo}")
    public ModelAndView editProductForm(@PathVariable("productNo") int productNo, HttpSession session) {
        Integer sellerNo = (Integer) session.getAttribute("sellerNo");

        if (sellerNo == null) {
            return new ModelAndView("redirect:/accountlogin");  
        }

        ProductVO product = productDAO.getProductByNo(productNo);
        
        // 상품의 판매자가 현재 로그인된 판매자인지 확인
        if (product.getSellerNo() != sellerNo) {
            return new ModelAndView("redirect:/seller/products/list");  
        }

        ModelAndView result = new ModelAndView("editProduct_form");
        result.addObject("product", product);
        return result;
    }

    // 상품 수정 처리
    @RequestMapping(value = "/edit/{productNo}", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute ProductVO product, HttpSession session) {
        Integer sellerNo = (Integer) session.getAttribute("sellerNo");

        if (sellerNo == null) {
            return "redirect:/accountlogin";  
        }

        // 수정하려는 상품이 현재 로그인한 판매자의 것인지 확인
        if (product.getSellerNo() != sellerNo) {
            return "redirect:/seller/products/list";  
        }

        productDAO.updateProduct(product);
        return "redirect:/seller/products/list";
    }

    // 상품 삭제 처리
    @RequestMapping("/delete/{productNo}")
    public String deleteProduct(@PathVariable("productNo") int productNo, HttpSession session) {
        Integer sellerNo = (Integer) session.getAttribute("sellerNo");

        if (sellerNo == null) {
            return "redirect:/accountlogin"; 
        }

        ProductVO product = productDAO.getProductByNo(productNo);

        // 삭제하려는 상품이 현재 로그인된 판매자의 것인지 확인
        if (product.getSellerNo() != sellerNo) {
            return "redirect:/seller/products/list";  
        }

        productDAO.deleteProduct(productNo); 
        return "redirect:/seller/products/list";
    }
}

