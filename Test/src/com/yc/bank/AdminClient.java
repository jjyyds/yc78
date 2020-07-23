package com.yc.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 管理员客户端
 * @author Administrator
 *
 */
public class AdminClient {
	public static void main(String[] args) throws IOException {
		Socket s=new Socket("localhost",9999);
		System.out.println("管理员客户端"+s.getRemoteSocketAddress()+"开始连接");
		Scanner sc=new Scanner(s.getInputStream());
		PrintWriter out=new PrintWriter(s.getOutputStream());
		String protocal="shutdown\n";
		out.println(protocal);
		out.flush();
		System.out.println("客户端安全退出");
		s.close();
	}
}
