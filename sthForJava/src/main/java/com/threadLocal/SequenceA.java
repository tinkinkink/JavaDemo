package com.threadLocal;

public class SequenceA implements Sequence{
	
	private static Integer num = 0;
	
	public Integer getNumber() {
		return num++;
	}
	
	public static void main(String[] args) {
		Sequence sequence = new SequenceA();
		ClientThread t1 = new ClientThread(sequence);
		ClientThread t2 = new ClientThread(sequence);
		ClientThread t3 = new ClientThread(sequence);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
