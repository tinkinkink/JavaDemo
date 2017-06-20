package com.lock;

/**
 * 读写锁，针对读和写操作进行控制，防止写的时候进行读操作或者读的时候进行写操作
 * 在JDK1.5之后存在类似的接口以及实现类
 * @author lzh
 *
 */
public class ReadWriteLock {
	
	//读线程计数器
	private int readThreadCounter = 0;
	//写线程计数器
	private int writeThreadCounter = 0;
	//等待线程计数器
	private int waitThreadCounter = 0;
	//是否优先写入标志
	private boolean writeFlag = true; 
	
	public synchronized void readLock() throws InterruptedException{
		//判断是否存在在写的线程或这在读的线程以及是否写入优先
		while(writeThreadCounter>0 || (waitThreadCounter>0 && writeFlag)){
			wait();
		}
		//使正在读的线程数加1
		readThreadCounter++;
	}
	
	public synchronized void readUnlock(){
		//使正在读的线程数减一
		readThreadCounter--;
		//将写入优先打开
		writeFlag = true;
		//唤醒正在wait()的线程
		notifyAll();
	}
	
	public synchronized void writeLock() throws InterruptedException{
		//使正在等待的线程数加一
		waitThreadCounter++;
		try{
			//判断正在读取和正在写入的线程是否存在
			while(readThreadCounter>0 || writeThreadCounter>0){
				wait();
			}			
		}finally {
			//正在等待线程数减一
			waitThreadCounter--;
		}
		//正在写入的线程数加一
		writeThreadCounter++;
	}
	
	public synchronized void writeUnlock(){
		//优先写入标志关闭
		writeFlag = false;
		//写入线程数减一
		writeThreadCounter--;
		//唤醒所有正在等待线程
		notifyAll();
	}
}
