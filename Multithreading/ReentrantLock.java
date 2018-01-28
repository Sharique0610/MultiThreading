package Multithreading;

import java.util.concurrent.locks.Lock;

public class ReentrantLock {

	static Integer count = 0;
	public static Object lock = new Object();
	public static ReentrantLock l = new ReentrantLock();

	public static void increment() {

		for (int i = 0; i < 10000; i++) {
			count++;
		}

	}
	
	

	public static void finished(float sec) {
		System.out.println("Count is : " + count + ". Time taken to complete is " + sec);
	}

	public static void main(String args[]) {

		long time = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();

			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long time2 = System.currentTimeMillis();
		float t = (float) (time2 - time);
		finished(t);
	}
}
