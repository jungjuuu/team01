package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.MemberDAO;
import com.cream.team01.vo.AccountVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class FindPasswordController {

	  @Autowired
	    private MemberDAO memberDAO;

	   
	  // GET 요청 처리: 비밀번호 찾기 페이지 표시
	    @RequestMapping(value = "/findpassword", method = RequestMethod.GET)
	    public String showFindPasswordForm() {
	        return "findpassword";  // 비밀번호 찾기 폼 페이지
	    }

	    // POST 요청 처리: 비밀번호 찾기 로직
	    @RequestMapping(value = "/findpassword", method = RequestMethod.POST)
	    public String findPassword(@RequestParam("accountId") String accountId,
	                               @RequestParam("memberMobile") String memberMobile,
	                               HttpSession session) {
	        try {
	            // DB에서 비밀번호 찾기 로직
	            AccountVO account = memberDAO.findPassword(accountId, memberMobile);
	            
	            if (account != null) {
	                session.setAttribute("accountPassword", account.getAccountPassword()); // 찾은 비밀번호를 세션에 저장
	                return "redirect:/findpassword";  // 비밀번호 찾기 페이지로 리다이렉트
	            } else {
	                session.setAttribute("loginMessage", "해당 정보로 회원가입한 비밀번호가 존재하지 않습니다.");
	                return "redirect:/findpassword";  // 에러 메시지를 표시하면서 다시 페이지로 리다이렉트
	            }
	        } catch (Exception e) {
	            e.printStackTrace();  // 예외를 콘솔에 출력
	            session.setAttribute("loginMessage", "오류가 발생했습니다: " + e.getMessage());
	            return "redirect:/findpassword";  // 에러 메시지를 표시하면서 다시 페이지로 리다이렉트
	        }
	    }
	}