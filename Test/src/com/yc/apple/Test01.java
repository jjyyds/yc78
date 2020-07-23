package com.yc.apple;

public class Test01 {
	public static void main(String[] args) {
		AppleBox ab=new AppleBox();
		Producer p=new Producer(ab);
		Customer c1=new Customer(ab);
		Customer c2=new Customer(ab);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}
