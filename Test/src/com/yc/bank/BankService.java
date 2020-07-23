package com.yc.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 银行服务
 * @author Administrator
 *
 */
public class BankService implements Runnable{
	private Socket s;
	private Bank bank;
	private Scanner sc;
	private PrintWriter out;
	
	public BankService(Bank bank,Socket s) {
		this.bank=bank;
		this.s=s;
	}
	
	@Override
	public void run() {
		//处理协议，给出响应
		try {
			sc=new Scanner(s.getInputStream());
			out=new PrintWriter(s.getOutputStream());
			//解析协议
			parseProtocal();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				this.s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//解析协议
	private void parseProtocal(){
		//死循环
		while(true){
			if(!sc.hasNext()){
				System.out.println("客户端"+this.s.getRemoteSocketAddress()+"已经掉线了");
				return;
			}
			//BALANCE 1\n
			//取出命令:第一种方式:sc.nextLine() --> str.split(" ")
			String command=sc.next();//读取第一个分隔符的位置
			if("QUIT".equals(command)){
				System.out.println("客户端"+this.s.getRemoteSocketAddress()+"已掉线");
				return;
			}
			//获取账号
			int accountId=sc.nextInt();
			if("DEPOSIT".equals(command)){
				double money=sc.nextDouble();
				this.bank.deposite(accountId, money);
			}else if("WITHDRAW".equals(command)){
				double money=sc.nextDouble();
				this.bank.withdraw(accountId, money);
			}else if(!"BALANCE".equals(command)){
				out.print("错误命令!!");
				out.flush();
				return;
			}
			out.println("账号"+accountId+"余额"+this.bank.getBalance(accountId));
			out.flush();
		}
	}

}
