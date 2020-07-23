package com.yc.apple;

import java.util.Random;

/**
 * 生产者
 * @author Administrator
 *
 */
public class Producer implements Runnable{
	//操作资源:applebox
	AppleBox ab=null;
	
	public Producer(AppleBox ab){
		this.ab=ab;
	}
	
	@Override
	public void run() {
		Random rd=new Random();
		for(int i=1;i<=20;i++){
			Apple app=new Apple(i);//创建一个苹果
			ab.deposite(app);//存苹果
			System.out.println("生产了:"+app.id+"苹果");
			try {
				Thread.sleep(rd.nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
