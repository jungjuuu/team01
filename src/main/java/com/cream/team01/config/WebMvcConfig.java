package com.cream.team01.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cream.team01.interceptor.LoginInterceptor;

@Configuration
@Component
	public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	LoginInterceptor loginInterceptor;
	
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(loginInterceptor)
	                //.excludePathPatterns("/css/**", "/images/**", "/js/**");
	        .addPathPatterns("/list.do")
	        .addPathPatterns("/abform.do");
	    }

}