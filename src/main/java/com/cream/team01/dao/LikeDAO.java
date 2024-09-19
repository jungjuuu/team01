package com.cream.team01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cream.team01.vo.LikeVO;

@Component
public class LikeDAO {

	@Autowired
	SqlSession session;
	
	// 좋아요 추가
    public void addLike(int productNo, int memberNo) {
        LikeVO like = new LikeVO(productNo, memberNo);
        session.insert("addLike", like);
    }

    // 좋아요 삭제
    public void removeLike(int productNo, int memberNo) {
        LikeVO like = new LikeVO(productNo, memberNo);
        session.delete("removeLike", like);
    }

    // 특정 사용자가 특정 상품에 좋아요를 눌렀는지 확인
    public boolean checkLike(int productNo, int memberNo) {
        LikeVO likeVO = new LikeVO();
        likeVO.setProductNo(productNo);
        likeVO.setMemberNo(memberNo);
        Integer count = session.selectOne("checkLike", likeVO);
        return count != null && count > 0;
    }

    // 특정 상품의 총 좋아요 수를 반환
    public int getLikesCount(int productNo) {
        return session.selectOne("getLikesCount", productNo);
    }
}
