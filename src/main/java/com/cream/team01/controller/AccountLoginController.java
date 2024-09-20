package com.cream.team01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.cream.team01.vo.AccountVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountLoginController {

    @Autowired
       private com.cream.team01.dao.AccountDAO accountDAO;
    
       // 로그인 페이지로 이동 (GET 요청)
       @RequestMapping(value = "/accountlogin", method = RequestMethod.GET)
       public String showLoginForm(HttpSession session) {
           // 세션에서 로그인 메시지 삭제
           session.removeAttribute("loginMessage");
           return "accountlogin";  // 로그인 폼 페이지로 이동
       }

    // 로그인 처리 (POST 요청)
       @RequestMapping(value = "/accountlogin", method = RequestMethod.POST)
       public String login(String accountId, String accountPassword, HttpSession session) {
           AccountVO account = accountDAO.selectAccount(accountId);
           
           if (account != null && account.getAccountPassword().equals(accountPassword)) {
               session.setAttribute("accountId", accountId);
               session.setAttribute("accountLevel", account.getAccountLevel());
               session.removeAttribute("loginMessage"); // 성공 시 이전 메시지 제거
               if (account.getAccountLevel() == 1) { 
                   Integer memberNo = accountDAO.getMemberNoByAccountNo(account.getAccountNo());
                   session.setAttribute("memberNo", memberNo);
                   int accountNo = account.getAccountNo();
                   session.setAttribute("accountNo", accountNo);
                   return "redirect:/main";
               } else { 
                   Integer sellerNo = accountDAO.getSellerNoByAccountNo(account.getAccountNo());
                   session.setAttribute("sellerNo", sellerNo);
                   return "redirect:/sellermypage/product/list";
               }
               
               
           } else {
               // 로그인 실패 메시지를 세션에 저장
               String loginMessage = "아이디 또는 비밀번호가 일치하지 않습니다.";
               session.setAttribute("loginMessage", loginMessage);
               return "accountlogin"; // 실패 시 로그인 페이지로 돌아가도록 수정
           }
       }  
       
       @RequestMapping("/accountlogout")
       public String logout(HttpSession session) {
           session.invalidate();
           return "redirect:/";
       }
      
   }


