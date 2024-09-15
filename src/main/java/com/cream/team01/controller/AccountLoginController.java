package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.vo.AccountVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountLoginController {

	 @Autowired
	    private com.cream.team01.dao.AccountDAO accountDAO;  // DAO 주입

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
	        // DB에서 회원 정보 조회
	        AccountVO account = accountDAO.selectAccount(accountId);

	        // 로그인 결과 메시지를 위한 변수
	        String loginMessage;

	        // 입력된 비밀번호와 DB의 비밀번호가 일치하는지 확인
	        if (account != null && account.getAccountPassword().equals(accountPassword)) {
	            session.setAttribute("accountId", accountId);  // 세션에 로그인 정보 저장
	            loginMessage = "로그인 성공!";  // 로그인 성공 시 메시지
	            System.out.println("로그인 시도한 사용자 정보: " + account.toString());
	            // 로그인 성공 시 메인 페이지로 이동
	            return "redirect:/home";  
	        } else {
	            // 로그인 실패 메시지를 세션에 저장
	            loginMessage = "로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.";
	            session.setAttribute("loginMessage", loginMessage);
	            // 로그인 실패 시 다시 로그인 폼으로 리다이렉트
	            return "redirect:/accountlogin";  
	        }
	    }  

	}

