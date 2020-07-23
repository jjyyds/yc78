package com.yc.pool;

import java.util.Vector;

public class ThreadPoolManager {
	private Vector<SimpleThread> vector;//存储线程集合
	private int initSize;
	private static final int DEFUALSIZE=10;//线程池的初始大小
	
	public void setInitSize(int initSize){
		this.initSize=initSize;
	}
	
	public ThreadPoolManager(){
		this(DEFUALSIZE);
	}

	public ThreadPoolManager(int initSize) {
		if(initSize<=0){
			this.initSize=DEFUALSIZE;
		}else{
			this.initSize=initSize;
		}
		vector=new Vector<SimpleThread>();
		for(int i=0;i<this.initSize;i++){
			SimpleThread sm=new SimpleThread(i+1);
			//sm.setDaemon(true);
			vector.add(sm);
			sm.start();
		}
	}
	
	//调度线程池中线程的方法
	public void process(Runnable task){
		int i;
		//循环，Vector中所有的线程，找到其中runningflag为false
		for(i=0;i<vector.size();i++){
			SimpleThread sm=vector.get(i);
			if(sm.isRunningFlag()==false){
				//找到后，调用这个线程settask
				//调用这个线程setRunningFlag(true)
				System.out.println("线程:"+sm.getThreadNumber()+"开始执行新的任务");
				sm.setTask(task);
				sm.setRunningFlag(true);
				return;
			}
		}
		//扩展线程池
		System.out.println("===============================");
		System.out.println("当前线程池的大小:"+this.initSize+"，已经没有空闲的线程了，自动扩容程序开始");
		System.out.println("===============================");
		if(i==vector.size()){
			int temp=i+10;
			this.initSize=temp;
			for(;i<temp;i++){
				SimpleThread sm=new SimpleThread(i+1);
				sm.setDaemon(true);
				vector.add(sm);
				sm.start();
			}
			this.process(task);//注意，再点调用调度方法给任务分配线程
		}
	}
	
	//线程池的销毁
	public void destory(){
		for(int i=0;i<vector.size();i++){
			SimpleThread sm=vector.get(i);
			sm.close();
		}
	}
}
