package com.yc.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务端
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket ss=new ServerSocket(9999);
		Scanner sc=new Scanner(System.in);
		System.out.println("服务器启动    监听"+ss.getLocalPort()+"端口");
		while(true){
			Socket s=ss.accept();//线程阻塞
			System.out.println("客户端"+s.getInetAddress()+"连接上服务器");
			Scanner clientReader=new Scanner(s.getInputStream());
			PrintWriter pw=new PrintWriter(s.getOutputStream());
			do{
				String response=clientReader.nextLine();
				System.out.println("客户端"+s.getInetAddress()+"向服务器说"+response);
				if("bye".equals(response)){
					System.out.println("客户端"+s.getInetAddress()+"主动断开服务器端的连接");
					break;
				}
				System.out.println("请输入服务器想对客户端说的话");
				String line=sc.nextLine();
				pw.println(line);
				pw.flush();
				if("bye".equals(line)){
					System.out.println("服务器强制与客户端"+s.getInetAddress()+"掉线");
					break;
				}
			}while(true);
		}
	}
}
