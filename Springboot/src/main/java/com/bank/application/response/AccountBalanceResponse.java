package com.bank.application.response;

public class AccountBalanceResponse {

	private int acctID;
	private int balance;
	private String acctStatus;
	public int getAcctID() {
		return acctID;
	}
	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAcctStatus() {
		return acctStatus;
	}
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}
	
	
}
