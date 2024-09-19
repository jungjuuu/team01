package com.cream.team01.vo;

public class CartVO {

	public int cartNo;
	public int cartDetailNo;
	public int cartQuantity;
	public int productNo;
	public int memberNo;
	
	public String productName;
	public String productImage;
	public int productPrice;
	
	
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
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
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
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
				+ ", productNo=" + productNo + ", memberNo=" + memberNo + ", productName=" + productName
				+ ", productImage=" + productImage + ", productPrice=" + productPrice + "]";
	}
	
	
}
