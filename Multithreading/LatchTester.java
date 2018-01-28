package Multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LatchTester {

	public static void main(String args[]) {

		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService ex = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 3; i++) {
			ex.submit(new UsingCountdownLatch(latch));
		}

		ex.shutdown();

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Completed");
	}
}
