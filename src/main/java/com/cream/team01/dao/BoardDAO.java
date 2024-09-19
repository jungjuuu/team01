package com.cream.team01.dao;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.BoardVO;
import com.cream.team01.vo.ProductVO;

@Component
public class BoardDAO {
    
    @Autowired
    SqlSession session;

    
    // 문의하기
    public void creatememberInquriyWrite(BoardVO board) {
    public void addMemberInquiryWrite(BoardVO board)  {
        session.insert("addMemberInquiryWrite", board);
    }

 // 문의 목록 가져오기
    public List<BoardVO> getMemberInquiries() {
        return session.selectList("getMemberInquiries");
    }

}


