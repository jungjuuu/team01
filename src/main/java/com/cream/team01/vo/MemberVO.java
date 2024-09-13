package com.cream.team01.vo;

public class MemberVO {
	
	public int memberNo;
	public String memberName;
	public int memberAge;
	public String memberMobile;
	public String memberAddress;
	public int accountNo;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberMobile() {
		return memberMobile;
	}
	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", memberName=" + memberName + ", memberAge=" + memberAge
				+ ", memberMobile=" + memberMobile + ", accountNo=" + accountNo + ", memberAddress=" + memberAddress
				+ "]";
	}
	
	
}
