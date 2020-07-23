package com.yc.pool;

public class Test {
	public static void main(String[] args) {
		ThreadPoolManager manager=new ThreadPoolManager(5);
		for(int i=0;i<10;i++){
			manager.process(new CountTask(new MyNotify(){
				@Override
				public void notifyResult(Object obj) {
					System.out.println(Thread.currentThread().getName()+"---"+obj);
				}
			}));
		}
	}
}

//计数的任务
class CountTask implements Runnable{
	private MyNotify myNotify;
	
	public CountTask(MyNotify myNotify){
		this.myNotify=myNotify;
	}
	
	@Override
	public void run() {
		int i=10;
		while(true){
			if(null!=myNotify){
				myNotify.notifyResult(i);
			}
			i--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i<=0){
				break;
			}
		}
	}
	
}
