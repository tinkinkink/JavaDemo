package com.lock;

public class ReadThread extends Thread/* implements Runnable*/{

	private final Data data;
	
	public ReadThread(Data data){
		this.data = data;
	}
	
	public void run() {
		int n = 0;
		while(n<10){
			try {
				String result = data.read();
				System.out.println(Thread.currentThread().getName()+"=>"+result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
	}
}
