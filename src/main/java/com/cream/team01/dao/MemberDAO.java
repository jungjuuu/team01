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

	public AccountVO findId(String memberName, String memberMobile) {
	    // MemberVO 객체를 생성하여 이름과 전화번호를 설정
	    MemberVO member = new MemberVO();
	    member.setMemberName(memberName);
	    member.setMemberMobile(memberMobile);
	    
	    // SQL 쿼리를 실행하여 아이디를 찾음
	    return session.selectOne("findId", member);
	}
}
