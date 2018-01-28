package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingExecutor implements Runnable {

	private int id;

	UsingExecutor(int id) {
		this.id = id;

	}

	@Override
	public void run() {
		System.out.println("Process Starts :" + id + " Thread Name : " + Thread.currentThread().getName());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Process Ends : Thread Name : " + Thread.currentThread().getName());
	}

	public static void main(String args[]) {

		ExecutorService service = Executors.newFixedThreadPool(2);
		for (int i = 1; i < 6; i++) {
			service.submit(new UsingExecutor(i));
		}

		service.shutdown();

		try {
			service.awaitTermination(1, TimeUnit.SECONDS);
			System.out.println("Await Perid ends");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
