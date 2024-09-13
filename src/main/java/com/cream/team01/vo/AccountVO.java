package com.cream.team01.vo;

public class AccountVO {

	public int accountNo;
	public String accountId;
	public String accountPassword;
	public int accountLevel;
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public int getAccountLevel() {
		return accountLevel;
	}
	public void setAccountLevel(int accountLevel) {
		this.accountLevel = accountLevel;
	}
	
	@Override
	public String toString() {
		return "AccountVO [accountNo=" + accountNo + ", accountId=" + accountId + ", accountPassword=" + accountPassword
				+ ", accountLevel=" + accountLevel + "]";
	}
	
	
	
}
