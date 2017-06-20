package com.lock;

public class Data {
	
	private final char[] buffer;
	private ReadWriteLock lock = new ReadWriteLock();
	
	public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = '*';
        }
    }
	
	public String read() throws InterruptedException{
		lock.readLock();
		try{
			return doRead();
		}finally{
			lock.readUnlock();
		}
	}
	
	public void write(char c) throws InterruptedException{
		lock.writeLock();
		try{
			doWrite(c);
		}finally{
			lock.writeUnlock();
		}
	}
	
	public String doRead() {
		StringBuilder aBuilder = new StringBuilder("");
		for(int i=0;i<buffer.length;i++){
			aBuilder.append(buffer[i]);
		}
		return aBuilder.toString();
	}
	
	public void doWrite(char c){
		for(int i=0;i<buffer.length;i++){
			buffer[i] = c;
		}
	}
	
	public String toString(){
		try {
			return read();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
