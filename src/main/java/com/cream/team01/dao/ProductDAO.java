package com.cream.team01.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.ProductVO;

@Component
public class ProductDAO {
    
    @Autowired
    SqlSession session;
    
    // 카테고리별로 상품 조회
    public List<ProductVO> getProductsByCategory(int categoryNo) {
        return session.selectList("getProductsByCategory", categoryNo);
    }
    
    // 상품 상세 조회
    public ProductVO getProductByNo(int productNo) {
        return session.selectOne("getProductByNo", productNo);
    }
}
