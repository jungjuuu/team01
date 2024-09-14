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

    public List<ProductVO> getProductsByCategory(int categoryNo) {
        return session.selectList("getProductsByCategory", categoryNo);
    }
}
