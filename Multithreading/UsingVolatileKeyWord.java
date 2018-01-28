package Multithreading;

import java.util.Scanner;

public class UsingVolatileKeyWord extends Thread {

	private volatile boolean running = true;
	private  volatile int i = 0;

	@Override
	public void run() {

		while (running) {

			System.out.println("Thread Is Running " + i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void shutdown() {

		running = false;
	}

	public static void main(String args[]) {

		UsingVolatileKeyWord t1 = new UsingVolatileKeyWord();

		t1.start();

		Scanner sc = new Scanner(System.in);

		t1.i = sc.nextInt();
		 sc.nextInt();
		t1.shutdown();

	}

}
