package com.cream.team01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


	
	@Mapper
	public interface AccountDAO {
	    // ID로 회원 정보 조회
	    com.cream.team01.vo.AccountVO selectAccount(@Param("accountId") String accountId);
	}
