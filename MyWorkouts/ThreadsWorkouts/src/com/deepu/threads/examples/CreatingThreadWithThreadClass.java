package com.deepu.threads.examples;

public class CreatingThreadWithThreadClass extends Thread{
	
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("I am executed by child thread");
		}
	}

}
