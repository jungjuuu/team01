package com.cream.team01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.AccountVO;
import com.cream.team01.vo.MemberVO;

@Component
public class MememberDAO {

	@Autowired
	SqlSession session;

	public MemberVO findId(String memberName, String memberMobile) {
		
		return null;
	}

	
	
	
}



