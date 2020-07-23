package com.yc.apple;
/**
 * 缓冲区  苹果盒子
 * @author Administrator
 *
 */
public class AppleBox {
	Apple [] apples=new Apple[5];
	int index=0;//记录苹果位置
	
	//放苹果
	public synchronized void deposite(Apple apple){
		while(index>=apples.length){
			System.out.println("苹果盒子已经装满，等待消费者消费");
			try {
				this.wait();//等待状态
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();//唤醒所有的线程  通知其他的wait状态的线程  让其激活  wait  notify  同步锁中使用
		apples[index]=apple;
		System.out.println(Thread.currentThread().getName()+"生成了编号为"+apple.id+"的苹果");
		index++;
	}
	
	//取苹果
	public synchronized Apple withdraw(){
		while(index<=0){
			System.out.println("苹果盒子已空，等待生产者生产");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();//唤醒所有的线程
		index--;
		System.out.println(Thread.currentThread().getName()+"消费者消费了编号为:"+apples[index].id+"的苹果");
		return apples[index];
	}
}
