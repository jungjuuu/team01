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

	// 판매자의 등록된 상품을 가져오는 메서드
	public List<ProductVO> getProductsBySeller(int sellerNo) {
		return session.selectList("getProductsBySeller", sellerNo);
	}

	// 상품 추가
	public void addProduct(ProductVO product) {
		session.insert("addProduct", product);
	}

	// 상품 수정
	public void updateProduct(ProductVO product) {
		session.update("updateProduct", product);
	}

	// 상품 삭제
	public void deleteProduct(int productNo) {
		session.delete("deleteProduct", productNo);
	}
	
	public List<ProductVO> getNewProducts() {
	    return session.selectList("getNewProducts");
	}
	
	public List<ProductVO> getProductsByCategorySortedByRecent(int categoryNo) {
	    return session.selectList("getProductsByCategorySortedByRecent", categoryNo);
	}

	public List<ProductVO> getProductsByCategorySortedByHighPrice(int categoryNo) {
	    return session.selectList("getProductsByCategorySortedByHighPrice", categoryNo);
	}

	public List<ProductVO> getProductsByCategorySortedByLowPrice(int categoryNo) {
	    return session.selectList("getProductsByCategorySortedByLowPrice", categoryNo);
	}

	public List<ProductVO> getProductsByCategorySortedByLikes(int categoryNo) {
	    return session.selectList("getProductsByCategorySortedByLikes", categoryNo);
	}
	

}
