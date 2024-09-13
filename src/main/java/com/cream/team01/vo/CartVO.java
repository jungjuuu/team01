package com.cream.team01.vo;

public class CartVO {

	public int cartNo;
	public int cartDetailNo;
	public String cartQuantity;
	public int productNo;
	public int memberNo;
	
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public int getCartDetailNo() {
		return cartDetailNo;
	}
	public void setCartDetailNo(int cartDetailNo) {
		this.cartDetailNo = cartDetailNo;
	}
	public String getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(String cartQuantity) {
		this.cartQuantity = cartQuantity;
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
		return "CartVO [cartNo=" + cartNo + ", cartDetailNo=" + cartDetailNo + ", cartQuantity=" + cartQuantity
				+ ", productNo=" + productNo + ", memberNo=" + memberNo + "]";
	}

	
	
}
