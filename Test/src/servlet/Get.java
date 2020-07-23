package servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//模拟get请求
public class Get{
	public static void main(String[] args) {
		Socket socket=null;
		DataOutputStream dos=null;
		try {
			InetAddress addr=InetAddress.getByName("localhost");
			String url="/myHttp/myServlet?uname=wong&upwd=a";
			socket=new Socket(addr,8080);
			dos=new DataOutputStream(socket.getOutputStream());
			String message="GET "+url+" HTTP/1.1\r\nHost:localhost\r\n\r\n";
			byte [] buffer=message.getBytes();
			dos.write(buffer);
			dos.flush();
			//创建web服务器响应的数据流
			BufferedReader httpResponse=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			String line="";
			while((line=httpResponse.readLine())!=null){
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null!=dos){
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null!=socket){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
