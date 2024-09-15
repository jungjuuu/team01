package com.team01.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cream.team01.dao.AccountDAO;
import com.cream.team01.vo.AccountVO;


import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {

    @Autowired
    private AccountDAO accountDAO;  // DAO 주입

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
        String loginMessage = "로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.";

        // 입력된 비밀번호와 DB의 비밀번호가 일치하는지 확인
        if (account != null && account.getAccountPassword().equals(accountPassword)) {
            session.setAttribute("accountId", accountId);  // 세션에 로그인 정보 저장
            loginMessage = "로그인 성공!";  // 로그인 성공 시 메시지
        }

        // 로그인 결과 메시지를 세션에 저장
        session.setAttribute("loginMessage", loginMessage);

        // 리다이렉트하지 않고 로그인 페이지로 다시 이동
        return "accountlogin";  // 로그인 폼 페이지로 다시 이동 (로그인 성공/실패 메시지 표시)
    }
    

	@RequestMapping(value= {"/", "/main.do"})
	public String main() {
		return "main";
	}
}
