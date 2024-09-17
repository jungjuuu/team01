package com.cream.team01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.CategoryVO;

@Component
public class CategoryDAO {

	@Autowired
	SqlSession session;

	// categoryNo로 categoryName 가져오기
	public CategoryVO getCategoryNameByNo(int categoryNo) {
		return session.selectOne("getCategoryNameByNo", categoryNo);

	}

}
