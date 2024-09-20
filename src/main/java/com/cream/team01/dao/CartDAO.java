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

	public void addCartItem(CartVO cart) {

		session.insert("addCartItem", cart);
	}

	public void addCartDetail(CartVO cartDetail) {

		session.insert("addCartDetail", cartDetail);
	}

	public CartVO getCartByMemberNo(Integer memberNo) {
		
		return session.selectOne("getCartByMemberNo", memberNo);
	}
	
	public void deleteCartItems(CartVO cvo) {
		
		session.delete("deleteCartItems", cvo);
	}
	
	
}
