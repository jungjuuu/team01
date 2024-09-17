package com.cream.team01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.AccountVO;
import com.cream.team01.vo.MemberVO;
import com.cream.team01.vo.OrderVO;

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

	  // 아이디와 전화번호로 비밀번호 찾기
    public AccountVO findPassword(String accountId, String memberMobile) {
        MemberVO member = new MemberVO();
        member.setMemberName(accountId); // 이름이 아닌 아이디를 설정합니다.
        member.setMemberMobile(memberMobile);
       
        // SQL 쿼리를 실행하여 비밀번호를 찾음
        return session.selectOne("findPassword", member);
    }

    
    // 결제 시 회원 정보 가져오기
	public MemberVO getMemberInfo(int memberNo) {
		
		return session.selectOne("getMemberInfo", memberNo);
	}

	// 로그인 회원의 주문 정보 가져오기
	public List<OrderVO> getOrderListByMemberNo(int memberNo) {

		return session.selectList("getOrderListByMemberNo", memberNo);
	}
	
	

}