package com.cream.team01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.AccountVO;
import com.cream.team01.vo.MemberVO;

@Component
public class AccountDAO {

	@Autowired
	SqlSession session;

	public AccountVO selectAccount(String accountId) {
		
		  return session.selectOne("selectAccount", accountId);
	}
	
	public int getMemberNoByAccountNo(int accountNo) {
        return session.selectOne("getMemberNoByAccountNo", accountNo); 
    }
	
	public int getSellerNoByAccountNo(int accountNo) {
        return session.selectOne("getSellerNoByAccountNo", accountNo);  // 셀러 정보 가져오기
    }

	
	
	
	
	// 비밀번호 재설정
    public int updatePassword(String accountId, String accountPassword) {
        AccountVO account = new AccountVO();
        account.setAccountId(accountId); // 아이디 설정
        account.setAccountPassword(accountPassword); // 새 비밀번호 설정
        
        // SQL 쿼리를 실행하여 비밀번호를 업데이트
        return session.update("updatePassword", account); // selectOne이 아닌 update 사용
    }
}
