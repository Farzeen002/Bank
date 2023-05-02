package com.bank.application.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acctID")
	private int acctID;
	
	
	private int balance;
	
	
	private String acctStatus;
	
	@Column(nullable=true, name = "c_id")
	private Integer c_id;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public Accounts() {

	}

	

	public Accounts(int balance, String acctStatus, int c_id) {
		super();
		
		this.balance = balance;
		this.acctStatus = acctStatus;
		this.c_id = c_id;
	}

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
    


