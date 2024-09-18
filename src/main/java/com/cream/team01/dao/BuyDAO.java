package com.cream.team01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.cream.team01.vo.OrderVO;

@Component
public class BuyDAO {

	@Autowired
	SqlSession session;

	public void addOrder(OrderVO order) {

		session.insert("addOrder", order);
	}
	
	public void addOrderDetail(OrderVO orderDetail) {
		
		session.insert("addOrderDetail", orderDetail);
	}

	
	
}
