package com.yc.apple;

import java.util.Random;

/**
 * 消费者
 * @author Administrator
 *
 */
public class Customer implements Runnable{
	//操作资源:applebox
	AppleBox ab=null;
	public Customer(AppleBox ab){
		this.ab=ab;
	}
	
	@Override
	public void run() {
		Random rd=new Random();
		for(int i=1;i<=20;i++){
			Apple app=ab.withdraw();//取出一个苹果
			System.out.println("在customer中开始消费:"+app.id+"苹果");
			try {
				Thread.sleep(rd.nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
