package Multithreading;

public class Printing1to9 {

	public int value;

	public Object lock = new Object();

	public static void main(String args[]) {

		Printing1to9 printing1to9 = new Printing1to9();

		MyThread mythread1 = printing1to9.new MyThread(0);

		MyThread mythread2 = printing1to9.new MyThread(1);

		MyThread mythread3 = printing1to9.new MyThread(2);

		Thread t1 = new Thread(mythread1);

		Thread t2 = new Thread(mythread2);

		Thread t3 = new Thread(mythread3);

		try {

			t1.start();

			t2.start();

			t3.start();

			t1.join();

			t2.join();

			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private class MyThread implements Runnable {

		private int position;

		MyThread(int post) {

			this.position = post;
		}

		@Override
		public void run() {

			while (value < 9) {

				synchronized (lock) {
					if (value % 3 == this.position) {

						value = value + 1;
						if (value <= 9) {
							System.out.println(Thread.currentThread().getName() + " " + "Value : " + value);
						}
					}

				}
			}

		}

	}
}
