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
       String sellerId = (String) session.getAttribute("sellerId");
       if(sellerId == null || sellerId.length() == 0) {
           response.sendRedirect("sellerlogin.do");
           return false;
       }
       return true;
   }
}
