package com.cream.team01.vo;

public class LikeVO {

	public int likeNo;
	public int likeCount;
	public int memberNo;
	
	
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	
	@Override
	public String toString() {
		return "LikeVO [likeNo=" + likeNo + ", likeCount=" + likeCount + ", memberNo=" + memberNo + "]";
	}
	
	
}
