package com.cream.team01.vo;

public class OrderVO {

	//각 회원들이 주문했을 때 마이페이지 주문내역의 리스트번호
	public int orderDetailNo;
	public int orderQuantity;
	public int orderPrice;
	
	//주문 한 것들의 전체 번호
	public int orderNo;
	public String orderdate;
	public int memberNo;
	public int cartNo;
	
	
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
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
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
				+ orderPrice + ", orderNo=" + orderNo + ", orderdate=" + orderdate + ", memberNo=" + memberNo
				+ ", cartNo=" + cartNo + "]";
	}
	
	
	
	
	
	
}
