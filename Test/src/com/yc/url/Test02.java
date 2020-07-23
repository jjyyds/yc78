package com.yc.url;

import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {
	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("http://www.hyycinfo.com");
		URL url1=new URL(url,"index.html?username=aaaa#test");
		System.out.println("协议"+url1.getProtocol());
		System.out.println("端口"+url1.getPort());
		System.out.println("主机信息"+url1.getHost());
		System.out.println("文件路径"+url1.getPath());
		System.out.println("文件名"+url1.getFile());
		System.out.println("相对路径"+url1.getRef());
	}
}
