package com.cream.team01.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

   
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
           throws Exception {
       System.out.println("LoginInterceptor.preHandler()");
       HttpSession session = request.getSession();
       String userId = (String) session.getAttribute("userId");
       if(userId == null || userId.length() == 0) {
           response.sendRedirect("login_form.do");
           return false;
       }
       return true;
   }
}