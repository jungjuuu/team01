package com.cream.team01.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.AccountVO;
import com.cream.team01.vo.MemberVO;
import com.cream.team01.vo.ProductVO;
import com.cream.team01.vo.SellerVO;

@Component
public class RegisterDAO {
    
    @Autowired
    SqlSession session;

    // 회원가입 id, password
    public void createAccount(AccountVO account) {
        session.insert("createAccount", account);
    }
    
    // 멤버회원가입
    public void createMember(MemberVO member) {
        session.insert("createMember", member);
    }
    
    // 브랜드회원가입
    public void createBrand(SellerVO seller) {
        session.insert("createBrand", seller);
    }

}

