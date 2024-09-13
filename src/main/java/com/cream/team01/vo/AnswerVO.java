package com.cream.team01.vo;

public class AnswerVO {

	public int answerNo;
	public String answerDate;
	public String answerContent;
	public int inquiryNo;
	public int sellerNo;
	
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public int getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}
	
	@Override
	public String toString() {
		return "AnswerVO [answerNo=" + answerNo + ", answerDate=" + answerDate + ", answerContent=" + answerContent
				+ ", inquiryNo=" + inquiryNo + ", sellerNo=" + sellerNo + "]";
	}
	
}
