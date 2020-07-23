package com.yc.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.yc.pool.ThreadPoolManager;

public class Server2 {
	public static void main(String[] args) throws Exception {
		ThreadPoolManager manager=new ThreadPoolManager(5);
		ServerSocket ss=new ServerSocket(10000);
		System.out.println("服务器启动,监听"+ss.getLocalPort()+"端口");
		while(true){
			Socket s=ss.accept();
			TalkTask1 t=new TalkTask1(s);
			manager.process(t);
		}
	}
}

class TalkTask1 implements Runnable{
	private Socket s;
	private Scanner sc=new Scanner(System.in);
	public TalkTask1(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		System.out.println("客户端"+s.getInetAddress()+"连接上服务器");
		try {
			Scanner clientReader=new Scanner(s.getInputStream());
			PrintWriter pw=new PrintWriter(s.getOutputStream());
			do{
				String response=clientReader.nextLine();
				System.out.println("客户端"+s.getInetAddress()+"向服务器说"+response);
				if("bye".equals(response)){
					System.out.println("客户端"+s.getInetAddress()+"主动断开与服务器端的连接");
					break;
				}
				System.out.println("请输入服务器想对客户端说的话");
				String line =sc.nextLine();
				pw.println(line);
				pw.flush();
				if("bye".equals(line)){
					System.out.println("服务器强制与客户端"+s.getInetAddress()+"掉线");
					break;
				}
			}while(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
