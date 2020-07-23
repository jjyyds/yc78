package com.yc.bank;

public class BankAccount {
	private double balance;//余额
	
	/**
	 * 获取账户余额
	 * @return
	 */
	public double getBalance(){
		return balance;
	}
	
	public BankAccount(double balance){
		this.balance=balance;
	}
	
	public BankAccount(){
		
	}
	
	/**
	 * 存钱
	 * @param amount
	 */
	public void deposite(double amount){
		balance=balance+amount;
	}
	
	/**
	 * 取钱
	 * @param amount
	 */
	public void withdraw(double amount){
		balance=balance-amount;
	}
}
