package com.cream.team01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.AccountVO;

@Component
public class AccountDAO {

	@Autowired
	SqlSession session;

	public AccountVO selectAccount(String accountId) {
		
		return null;
	}
	
	
}
