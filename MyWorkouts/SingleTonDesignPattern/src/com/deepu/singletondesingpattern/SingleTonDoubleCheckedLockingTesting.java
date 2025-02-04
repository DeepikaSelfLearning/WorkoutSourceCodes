package com.deepu.singletondesingpattern;

public class SingleTonDoubleCheckedLockingTesting implements Runnable {

	private static SingleTonDoubleCheckedLockingTesting instance;
	static SingleTonDoubleCheckedLockingTesting singleTonInstance1;
	static SingleTonDoubleCheckedLockingTesting singleTonInstance2;

	private SingleTonDoubleCheckedLockingTesting() {

	}

	public static SingleTonDoubleCheckedLockingTesting getInstance() {
		if (instance == null) {
			synchronized (SingleTonDoubleCheckedLockingTesting.class) {
				if (instance == null) {
					instance = new SingleTonDoubleCheckedLockingTesting();
				}
			}
		}
		return instance;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			singleTonInstance1 = SingleTonDoubleCheckedLockingTesting.getInstance();
			System.out.println(singleTonInstance1);
			singleTonInstance2 = SingleTonDoubleCheckedLockingTesting.getInstance();
			System.out.println(singleTonInstance2);
		}
	}

	public static void main(String[] args) {

		SingleTonDoubleCheckedLockingTesting singleTonInstance = SingleTonDoubleCheckedLockingTesting.getInstance();

		Thread thread1 = new Thread(singleTonInstance);
		thread1.start();

		Thread thread2 = new Thread(singleTonInstance);
		thread2.start();

	}

}