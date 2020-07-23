package com.yc.url;

import java.net.InetAddress;
import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) throws Exception {
		InetAddress add=InetAddress.getLocalHost();
		System.out.println("计算机名:"+add.getHostName());
		System.out.println("IP地址:"+add.getHostAddress());
		byte []bt=add.getAddress();
		System.out.println("字节数组形式IP:"+Arrays.toString(bt));
		System.out.println(add);
		InetAddress add2=InetAddress.getByName("www.baidu.com");
		System.out.println(add2);
		add2=InetAddress.getByName("P-V-12");
		System.out.println(add2);
	}
}
