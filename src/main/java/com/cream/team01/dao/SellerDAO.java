package com.cream.team01.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.SellerVO;

@Component
public class SellerDAO {

	@Autowired
	SqlSession session;

	// sellerNo로 판매자 정보 가져오기
	public SellerVO getSellerByNo(int sellerNo) {
		return session.selectOne("getSellerByNo", sellerNo);
		
	}
	
   
	
	// 멤버 로그인
	
	// 판매자 로그인
	
	
}
