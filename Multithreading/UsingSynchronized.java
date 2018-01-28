package Multithreading;

public class UsingSynchronized {

	private int counter = 0;

	public static void main(String args[]) {

		UsingSynchronized usingSynchronized = new UsingSynchronized();

		usingSynchronized.startIncrementing();
	}

	// Synchronized methods of an object can only be called by a single thread
	// at a time as it has to get the intrinsic lock or mutex and all other
	// threads have to wait until the lock has been removed .i.e the method
	// completes its execution.
	// No need to declare a varible volatile in case of synchronized block as
	// what volatile does is, it actually makes the current state of the variable
	// visible to all the threads accessing it. And in case of synchronized
	// block it is already handled by it.

	public synchronized void increment() {

		counter++;
	}

	public void startIncrementing() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {

					increment();
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {

					increment();
				}

			}

		});

		t1.start();

		t2.start();

		try {
			t1.join();

			t2.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("Count is : " + counter);

	}
}
