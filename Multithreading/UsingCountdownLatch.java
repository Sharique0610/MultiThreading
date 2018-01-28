package Multithreading;

import java.util.concurrent.CountDownLatch;

public class UsingCountdownLatch implements Runnable {

	private CountDownLatch latch;

	UsingCountdownLatch(CountDownLatch latch) {

		this.latch = latch;
	}

	@Override
	public void run() {

		System.out.println("Starting Work " + "Latch Count : " + latch.getCount() + " Thread Name : "
				+ Thread.currentThread().getName());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("Work Ends " + "Latch Count : " + latch.getCount() + " Thread Name : "
				+ Thread.currentThread().getName());

	}

}
