package com.cream.team01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.AccountVO;
import com.cream.team01.vo.MemberVO;

@Component
public class MemberDAO {

	@Autowired
	SqlSession session;

	public MemberVO findId(String memberName, String memberMobile) {
        
        return null;
    }
	
}
