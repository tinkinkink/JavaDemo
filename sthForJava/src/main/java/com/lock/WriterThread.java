package com.lock;

public class WriterThread extends Thread implements Runnable{

	private final Data data;
	private final String str;
	private int index = 0;
	
	public WriterThread(Data data,String str){
		this.data = data;
		this.str = str;
	}
	
	public void run(){
		int n = 0;
		while(n<10){
			char c = next();
            try {
				data.write(c);
				System.out.println(Thread.currentThread().getName()+"=>"+c);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
	}
	
	private char next() {
        char c = str.charAt(index);
        index++;
        if (index >= str.length()) {
            index = 0;
        }
        return c;
    }
}
