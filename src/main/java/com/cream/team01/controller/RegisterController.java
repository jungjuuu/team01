package com.cream.team01.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cream.team01.dao.RegisterDAO;
import com.cream.team01.vo.AccountVO;
import com.cream.team01.vo.MemberVO;
import com.cream.team01.vo.SellerVO;

@Controller
public class RegisterController {

    @Autowired
    private RegisterDAO registerDAO;

    // 멤버 회원가입 폼을 제공하는 GET 요청
    @RequestMapping(value = "/memberregister", method = RequestMethod.GET)
    public String showMemberRegisterForm() {
        return "memberregister"; // 회원가입 폼 페이지 반환
    }

    // 멤버 회원가입 처리 (POST 요청)
    @RequestMapping(value = "/memberregister", method = RequestMethod.POST)
    public String addMemberRegisterForm(@ModelAttribute AccountVO account, @ModelAttribute MemberVO member) {
        registerDAO.createAccount(account);
        member.setAccountNo(account.getAccountNo());
        registerDAO.createMember(member);
        return "redirect:/accountlogin"; // 회원가입 후 로그인 페이지로 리다이렉션
    }

    // 브랜드 회원가입 폼을 제공하는 GET 요청
    @RequestMapping(value = "/sellerregister", method = RequestMethod.GET)
    public String showSellerRegisterForm() {
        return "sellerregister"; // 브랜드 회원가입 폼 페이지 반환
    }

    // 브랜드 회원가입 처리 (POST 요청)
    @RequestMapping(value = "/sellerregister", method = RequestMethod.POST)
    public String addSellerRegisterForm(@ModelAttribute AccountVO account, @ModelAttribute SellerVO seller) {
        registerDAO.createAccount(account);
        seller.setAccountNo(account.getAccountNo());
        registerDAO.createBrand(seller);
        return "redirect:/accountlogin"; // 회원가입 후 로그인 페이지로 리다이렉션
    }
}