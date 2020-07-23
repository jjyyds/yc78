package com.yc.bank;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.yc.pool.ThreadPoolManager;

/**
 * 编写服务器
 * @author Administrator
 *
 */
public class BankServer {
	static boolean flag=true;
	public static void main(String[] args) throws IOException {
		System.out.println("启动线程池");
		ThreadPoolManager manager=new ThreadPoolManager(5);
		Thread t=new Thread(new AdminTask());
		t.start();
		System.out.println("管理端启动");
		System.out.println("银行服务器启动");
		ServerSocket ss=new ServerSocket(8888);
		while(flag){
			Socket s=ss.accept();
			System.out.println("客户端"+s.getRemoteSocketAddress()+"连接上来了");
			Bank bank=new Bank(10);
			BankService service=new BankService(bank, s);
			//扩展多线程
			manager.process(service);
//			Thread t=new Thread(service);
//			t.start();
		}
		System.out.println("服务器关闭");
	}
}

class AdminTask implements Runnable{
	boolean flag=true;
	
	@Override
	public void run() {
		try {
			ServerSocket ss=new ServerSocket(9999);
			while(flag){
				Socket s=ss.accept();
				Scanner sc=new Scanner(s.getInputStream());
				String line=sc.nextLine();
				System.out.println(line+"----------------------");
				if("shutdown".equals(line)){
					//清空缓存
					//数据持久化
					//.......
					flag=false;
					BankServer.flag=false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
