package com.cream.team01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuyDAO {

	@Autowired
	SqlSession session;
	
	
}
