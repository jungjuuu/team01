package com.cream.team01.vo;

public class LikeVO {

	public int likeNo;
	public int productNo;
	public int memberNo;
	public int likeProductCount;
	
	
	public LikeVO() {
		
	}
	
	public LikeVO(int productNo, int memberNo) {
		this.productNo = productNo;
		this.memberNo = memberNo;
	}
	
	public int getLikeProductCount() {
		return likeProductCount;
	}

	public void setLikeProductCount(int likeProductCount) {
		this.likeProductCount = likeProductCount;
	}
	
	
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "LikeVO [likeNo=" + likeNo + ", productNo=" + productNo + ", memberNo=" + memberNo
				+ ", likeProductCount=" + likeProductCount + "]";
	}
	
}
