package com.yc.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test03 {
	public static void main(String[] args) throws Exception {
		URL url=new URL("http://www.hnit.edu.cn");
		InputStream in=url.openStream();//打开到此url的连接并返回一个用于从该连接读入的inputStream
		//将字节输入流转换字符输入流
		InputStreamReader reader=new InputStreamReader(in);
		BufferedReader rd=new BufferedReader(reader);
		String data=null;
		while((data=rd.readLine())!=null){
			System.out.println(data);
		}
		rd.close();
		reader.close();
		in.close();
		//获取某个页面数据，正则表达式匹配所有地址<a href=""></a>
		//将京东上面所有书籍信息爬出来  价格 名称  出版社
	}
}
