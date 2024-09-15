package com.team01.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cream.team01.dao.MemberDAO;
import com.cream.team01.vo.MemberVO;

import jakarta.servlet.http.HttpSession;

@Controller

public class FindIdController {

	   // @Autowired
	    //private com.edu.myboot.dao.AccountDAO accountDAO;
	    @Autowired
	    private MemberDAO memberDAO; 
	  
	    @PostMapping("/findid") // POST 요청으로 변경
	    public String findId(@RequestParam("memberName") String memberName,
	                         @RequestParam("memberMobile") String memberMobile,
	                         HttpSession session) {
	        // Repository를 직접 호출하여 accountId를 찾음
	        MemberVO member = memberDAO.findId(memberName, memberMobile); // MemberDAO의 findId 메서드 호출
	        
	        if (member != null) {
	            session.setAttribute("accountId", member.getAccountNo()); // accountId 저장
	            session.setAttribute("memberName", member.getMemberName());
	            return "redirect:/findid"; // redirect 경로를 수정할 수 있음
	        } else {
	            return "해당 정보로 회원가입한 아이디가 존재하지 않습니다."; // 에러 메시지
	        }
	    }
	}