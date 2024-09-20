package com.cream.team01.vo;

import org.springframework.beans.factory.annotation.Autowired;

public class BuyVO {

	// 각 회원들이 주문했을 때 마이페이지 주문내역의 리스트번호
	public int orderDetailNo;
	public int orderQuantity;
	public int orderPrice;

	// 주문 한 것들의 전체 번호
	public int orderNo;
	public String orderDate;
	public int memberNo;
	public int cartNo;
	
	public int productNo;
	public String productName;
	public String productImage;
	public int productPrice;
	
	
	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	
	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

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


	
	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(int orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "OrderVO [orderDetailNo=" + orderDetailNo + ", orderQuantity=" + orderQuantity + ", orderPrice="
				+ orderPrice + ", orderNo=" + orderNo + ", orderDate=" + orderDate + ", memberNo=" + memberNo
				+ ", cartNo=" + cartNo + ", productNo=" + productNo + ", productName=" + productName + ", productImage="
				+ productImage + ", productPrice=" + productPrice + "]";
	}

	

	
}
