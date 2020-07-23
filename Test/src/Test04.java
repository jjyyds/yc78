
public class Test04 implements Runnable{
	int i=0;
	public boolean flag;
	public static Producers p=new Producers();
	public static Consumers c=new Consumers();
	public static void main(String[] args) {
		Test04 t1=new Test04();
		t1.flag=true;
		
		Test04 t2=new Test04();
		t2.flag=true;
		new Thread(t2,"c").start();
		new Thread(t1,"c1").start();
		new Thread(t1,"p").start();
		
//		new Thread(t1,"p").start();
//		new Thread(t1,"c").start();
//		new Thread(t1,"p").start();
//		new Thread(t1,"c").start();
	}
	@Override
	public void run() {
		synchronized (this) {
			if("c".equals(Thread.currentThread().getName()) || "c1".equals(Thread.currentThread().getName())){
				try {
					System.out.println(Thread.currentThread().getName()+"wait");
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while(flag){
				if("p".equals(Thread.currentThread().getName())){
					p.say();
					i++;
					System.out.println(Thread.currentThread().getName()+"现在盒子有"+i+"个苹果");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					c.say();
					i--;
					System.out.println(Thread.currentThread().getName()+"现在盒子有"+i+"个苹果");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"notifyAll");
				this.notifyAll();
				try {
					System.out.println(Thread.currentThread().getName()+"wait");
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Producers{
	public void say(){
		System.out.println("我生产了一个苹果");
	}
}

class Consumers{
	public void say(){
		System.out.println("我消费了一个苹果");
	}
}