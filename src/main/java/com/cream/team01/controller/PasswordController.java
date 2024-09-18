package com.cream.team01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.dao.AccountDAO;
import com.cream.team01.dao.MemberDAO;
import com.cream.team01.vo.AccountVO;
import com.cream.team01.vo.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class PasswordController {
	
		@Autowired
	    private AccountDAO accountDAO;

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
	                return "redirect:/updatepassword";  // 비밀번호 찾기 페이지로 리다이렉트
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
	    
	  
	 // 비밀번호 재설정 페이지 표시 (GET 요청 처리)
	    @RequestMapping(value = "/updatepassword", method = RequestMethod.GET)
	    public String showUpdatePasswordForm(HttpSession session) {
	        // 세션에서 accountId를 가져온다
	        String accountId = (String) session.getAttribute("accountId");
	        if (accountId != null) {
	            return "updatepassword";  // 비밀번호 재설정 페이지로 이동
	        } else {
	            return "redirect:/findpassword";  // accountId가 없으면 비밀번호 찾기 페이지로 리다이렉트
	        }
	    }

	    // 비밀번호 수정 처리 (POST 요청 처리)
	    @RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	    public String updatePassword(
	            @RequestParam("accountPassword") String accountPassword,
	            @RequestParam("accountPasswordConfirm") String accountPasswordConfirm,
	            HttpSession session) {
	        // 세션에서 accountId를 가져온다
	        String accountId = (String) session.getAttribute("accountId");
	        if (accountId != null) {
	            if (accountPassword.equals(accountPasswordConfirm)) {  // 비밀번호 확인
	                try {
	                    int result = accountDAO.updatePassword(accountId, accountPassword);
	                    if (result > 0) {
	                        session.setAttribute("successMessage", "비밀번호가 성공적으로 수정되었습니다.");
	                        return "redirect:/main";  // 성공 시 메인 페이지로 리다이렉트
	                    } else {
	                        session.setAttribute("errorMessage", "비밀번호를 수정할 수 없습니다.");
	                        return "redirect:/updatepassword";  // 에러 메시지와 함께 다시 리다이렉트
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    session.setAttribute("errorMessage", "오류가 발생했습니다: " + e.getMessage());
	                    return "redirect:/updatepassword";  // 에러 메시지와 함께 다시 리다이렉트
	                }
	            } else {
	                session.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
	                return "redirect:/updatepassword";  // 비밀번호 불일치 에러
	            }
	        } else {
	            return "redirect:/findpassword";  // accountId가 없으면 비밀번호 찾기 페이지로 리다이렉트
	        }
	    }
	}

	    
	    
	    
