package com.yc.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 编写客户端
 * @author Administrator
 *
 */
public class AtmBank {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("localhost",8888);
		System.out.println("atm客户端启动了,并连接到"+socket.getRemoteSocketAddress());
		Scanner sc=new Scanner(socket.getInputStream());
		PrintWriter pw=new PrintWriter(socket.getOutputStream());
		
		//查看余额
		String protocal="BALANCE 1\n";
		pw.println(protocal);
		pw.flush();
		//取出响应信息
		String response=sc.nextLine();
		System.out.println("服务器响应信息:"+response);
		
		//存款
		protocal="DEPOSIT 1 800\n";
		pw.println(protocal);
		pw.flush();
		//取出响应信息
		response=sc.nextLine();
		System.out.println("服务器响应信息:"+response);
		
		//取款
		protocal="WITHDRAW 1 100\n";
		pw.println(protocal);
		pw.flush();
		//取出响应信息
		response=sc.nextLine();
		System.out.println("服务器响应信息:"+response);
		
		//退出
		protocal="QUIT\n";
		pw.println(protocal);
		pw.flush();
		System.out.println("安全退出");
	}
}
