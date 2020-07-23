package com.yc.bank;

import java.util.Vector;

/**
 * 银行
 * @author Administrator
 *
 */
public class Bank {
	private Vector<BankAccount> accounts;//多个银行账户
	
	/**
	 * 初始化银行，默认添加一些账号
	 * @param initSize
	 */
	public Bank(int initSize){
		accounts=new Vector<BankAccount>();
		for(int i=0;i<initSize;i++){
			accounts.add(new BankAccount());
		}
	}
	
	/**
	 * 存钱
	 * @param accountId
	 * @param amount
	 */
	public void deposite(int accountId,double amount){
		accounts.get(accountId).deposite(amount);
	}
	
	/**
	 * 取钱业务
	 * @param accountId
	 * @param amount
	 */
	public void withdraw(int accountId,double amount){
		if(accounts.get(accountId).getBalance()<amount){
			System.out.println("余额不足");
			return;
		}
		accounts.get(accountId).withdraw(amount);
	}
	
	/**
	 * 获取余额
	 * @param accountId
	 * @return
	 */
	public double getBalance(int accountId){
		return accounts.get(accountId).getBalance();
	}
}
