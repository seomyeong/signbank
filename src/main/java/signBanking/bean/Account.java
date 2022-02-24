package signBanking.bean;

import java.util.Date;

public class Account {
	private long id;
	private long customerId;
	protected double balance;
	private Customer customer;
	private String accountNum;
	private char accType;
	private Date regDate; //----수민변수선언
	private double interestRate;
	private double overAmount;
	
	public Account() {}
	public Account(double balance) {
		this.balance = balance;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public char getAccType() {
		return accType;
	}
	public void setAccType(char accType) {
		this.accType = accType;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}		
	
	
	
	
	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public double getOverAmount() {
		return overAmount;
	}


	public void setOverAmount(double overAmount) {
		this.overAmount = overAmount;
	}

	
}