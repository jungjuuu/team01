package com.cream.team01.vo;

public class SellerVO {

	public int sellerNo;
	public String brandName;
	public String sellerMobile;
	public int accountNo;
	
	public int getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}
	public String getbrandName() {
		return brandName;
	}
	public void setbrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getSellerMobile() {
		return sellerMobile;
	}
	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	@Override
	public String toString() {
		return "SellerVO [sellerNo=" + sellerNo + ", brandName=" + brandName + ", sellerMobile=" + sellerMobile + ", accountNo="
				+ accountNo + "]";
	}
	
	
}
