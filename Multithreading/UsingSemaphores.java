package Multithreading;

public class UsingSemaphores {

	public static volatile int checker = 0;
	public static int s1 = 0;
	public static int s2 = 0;
	public static int s3 = 1;

	public static void main(String args[]) {

		System.out.println("Code Starts " + Thread.currentThread().getName());

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				while (checker < 10) {

					s3 = waiting(s3);
					print();
					s1 = signal(s1);

				}

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (checker < 10) {

					s1=waiting(s1);
					print();
					s2=signal(s2);
				}

			}

		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {

				while (checker < 10) {

					s2=waiting(s2);
					print();
					s3=signal(s3);
				}
			}

		});

		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Code Completes");

	}

	public static int signal(int i) {

		i++;

		return i;

	}

	public static int waiting(int i) {

		while (i <= 0)
			;
		i--;

		return i;

	}

	public static void print() {

		checker = checker + 1;

		System.out.println("Thread Name : " + Thread.currentThread().getName() +" Checker Value : "+checker);

	}
}
