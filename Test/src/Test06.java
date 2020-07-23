import java.util.Random;

/**
 * 资源争抢  -->锁   -->同步锁
 * @author 衡阳吴彦祖
 *
 */
public class Test06 {
	public static void main(String[] args) {
		SellTicketOp op=new SellTicketOp();
		Thread t1=new Thread(op,"张三");
		Thread t2=new Thread(op,"李四");
		Thread t3=new Thread(op,"王五");
		t1.start();
		t2.start();
		t3.start();
	}
}

class SellTicketOp implements Runnable{
	int ticket=300;
	Random rd=new Random();
	boolean flag=true;
	@Override
	public void run() {
		while(flag){
			//修饰代码块
			synchronized (this) {
				if(ticket>0){
					try {
						Thread.sleep(rd.nextInt(80));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"在sell第"+(ticket--)+"张票");
				}else{
					return;
				}
			}
		}
	}
	
	//修饰方法
	public synchronized void sale() {
		if(ticket>0){
			try {
				Thread.sleep(rd.nextInt(20));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"在sell第"+(ticket--)+"张票");
		}else{
			return;
		}
	}
}
