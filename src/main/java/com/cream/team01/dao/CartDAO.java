package com.cream.team01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.CartVO;
import com.cream.team01.vo.MemberVO;

@Component
public class CartDAO {

	
	@Autowired
	SqlSession session;
	
	public List<CartVO> getCartItems(MemberVO member) {
		
		return session.selectList("getCartItems", member);
	}
	
	
}
