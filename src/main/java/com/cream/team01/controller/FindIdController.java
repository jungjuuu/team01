package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cream.team01.dao.MememberDAO;
import com.cream.team01.vo.MemberVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class FindIdController {

    @Autowired
    private MememberDAO memberDAO;

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
    	
        // DB에서 아이디 찾기 로직
        MemberVO member = memberDAO.findId(memberName, memberMobile);

        if (member != null) {
            session.setAttribute("accountId", member.getAccountNo()); // 찾은 계정 ID를 세션에 저장
            session.setAttribute("memberName", member.getMemberName());
            return "redirect:/findid";  // 아이디 찾기 페이지로 리다이렉트
        } else {
            session.setAttribute("loginMessage", "해당 정보로 회원가입한 아이디가 존재하지 않습니다.");
            return "redirect:/findid";  // 에러 메시지를 표시하면서 다시 페이지로 리다이렉트
        }
    }
}
