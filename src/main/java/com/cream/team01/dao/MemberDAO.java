package com.cream.team01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

	
	@Mapper
	public interface MemberDAO {
		com.cream.team01.vo.MemberVO findId(@Param("memberName") String memberName, @Param("memberMobile") String memberMobile);
	
	}


