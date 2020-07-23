import java.util.ArrayList;
import java.util.List;

public class Test {
	//存放苹果
	List<Object> list=new ArrayList<Object>();
	
	public synchronized void produce(String name){
		while(list.size()==5){
			try {
				System.out.println("盒子装满了苹果!");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		list.add("apple");
		System.out.println(Thread.currentThread().getName()+"生产了1个苹果,盒子里有"+list.size()+"个苹果");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void consume(String name){
		while(list.size()==0){
			try {
				System.out.println("盒子里没有苹果了!");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		list.remove(0);
		System.out.println(Thread.currentThread().getName()+"购买了1个苹果,盒子里剩"+list.size()+"个苹果");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		Consumer c1=new Consumer(t);
		Consumer c2=new Consumer(t);
		Producer p1=new Producer(t);
		Producer p2=new Producer(t);
		Producer p3=new Producer(t);
		Thread t1=new Thread(p1,"生产者1号");
		Thread t2=new Thread(p2,"生产者2号");
		Thread t3=new Thread(p3,"生产者3号");
		Thread t4=new Thread(c1,"消费者1号");
		Thread t5=new Thread(c2,"消费者2号");
		t4.setPriority(10);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

/**
 * 消费者
 */
class Consumer implements Runnable{
	Test t=null;
	
    public Consumer(Test t) {
		this.t=t;
	}
	 
	@Override
	public void run() {
		while(true){
			synchronized (Consumer.class) {
				t.consume(Thread.currentThread().getName());;
			}
		}
	}
}

/**
 * 生产者
 */
class Producer implements Runnable{
	Test t=null;
	public Producer(Test t) {
		this.t=t;
	}
	@Override
	public void run() {
		while(true){
			synchronized (Producer.class) {
				t.produce(Thread.currentThread().getName());
			}
		}
	}
}