package Multithreading;

public class LowLevelProducerConsumerTester {

	public static void main(String args[]) {

		LowLevelProducerConsumer obj = new LowLevelProducerConsumer();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					obj.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					obj.consumer();
				} catch (InterruptedException e) {

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
