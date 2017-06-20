package com.threadLocal;

public class SequenceB implements Sequence {

	/**
	 * ThreadLocal类
	 * 为一条线程保存一个局部变量，这个变量只由该线程使用，并且通过ThreadLocal这个类对象来获取
	 * ThreadLocal内部维护一个Map<Thread , T >，跟随线程而使用，不同于静态变量线程间共同使用，该变量只由创建这个变量的线程使用
	 * public void set(T value)：将值放入线程局部变量中
	 * public T get()：从线程局部变量中获取值
	 * public void remove()：从线程局部变量中移除值（有助于 JVM 垃圾回收）
	 * protected T initialValue()：返回线程局部变量中的初始值（默认为 null） 
	 */
	
	private ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		}
	};
	
	public Integer getNumber() {
		numberContainer.set(numberContainer.get()+1);
		return numberContainer.get();
	}
	
	public static void main(String[] args) {
		Sequence sequence = new SequenceB();
		ClientThread t1 = new ClientThread(sequence);
		ClientThread t2 = new ClientThread(sequence);
		ClientThread t3 = new ClientThread(sequence);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}
