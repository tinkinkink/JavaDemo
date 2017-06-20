package com.lock;

public class Client {
	public static void main(String[] args) {
		Data data = new Data(10);
		
		new ReadThread(data).start();
		new ReadThread(data).start();
		new WriterThread(data,"123").start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		

		new WriterThread(data,"ABC").start();
		
		
	}
}
