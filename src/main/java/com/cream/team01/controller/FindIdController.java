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
public class FindIdController {

	  @Autowired
	    private MemberDAO memberDAO;

	    // GET 요청 처리: 아이디 찾기 페이지 표시
	    @RequestMapping(value = "/findid", method = RequestMethod.GET)
	    public String showFindIdForm() {
	        return "findid";  // `findid.html` 페이지를 반환 (아이디 찾기 폼 페이지)
	    }

	    // POST 요청 처리: 아이디 찾기 로직
	    @RequestMapping(value = "/findid", method = RequestMethod.POST)
	    public String findId(@RequestParam("memberName") String memberName,
	                         @RequestParam("memberMobile") String memberMobile,
	                         HttpSession session) {
	        try {
	            // DB에서 아이디 찾기 로직
	            AccountVO account = memberDAO.findId(memberName, memberMobile);
	            
	            if (account != null) {
	                session.setAttribute("accountId", account.getAccountId()); // 찾은 계정 ID를 세션에 저장
	                session.setAttribute("memberName", memberName); // 사용자의 이름 저장
	                return "redirect:/findid";  // 아이디 찾기 페이지로 리다이렉트
	            } else {
	                session.setAttribute("loginMessage", "해당 정보로 회원가입한 아이디가 존재하지 않습니다.");
	                return "redirect:/findid";  // 에러 메시지를 표시하면서 다시 페이지로 리다이렉트
	            }
	        } catch (Exception e) {
	            e.printStackTrace();  // 예외를 콘솔에 출력
	            session.setAttribute("loginMessage", "오류가 발생했습니다: " + e.getMessage());
	            return "redirect:/findid";  // 에러 메시지를 표시하면서 다시 페이지로 리다이렉트
	        }
	    }
}