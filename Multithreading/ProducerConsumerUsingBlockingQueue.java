package Multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void producer() {

	
		Random random = new Random();

		while (true) {
			try {
				Thread.sleep(1000);
				queue.put(random.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void consumer() throws InterruptedException {

		
		Random random = new Random();

		while (true) {
			try {
				Thread.sleep(1000);
				if (random.nextInt(10) == 1) {
					Integer value = queue.take();
					System.out.println(
							"Removing Entry from Queue Value : " + value + "  Size of Queue  : " + queue.size());
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {

		System.out.println("Process starts");
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				producer();
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	}
}
