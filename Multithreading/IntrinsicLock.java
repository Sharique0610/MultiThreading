package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntrinsicLock {

	Random random = new Random();
	private List<Integer> list1 = new ArrayList<Integer>();

	private List<Integer> list2 = new ArrayList<Integer>();
	
	private Object object1=new Object();
	private Object object2=new Object();

	public  void addInList1() {

		synchronized(object1){
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		list1.add(random.nextInt(100));
		}
	}

	public  void addInList2() {

		synchronized(object2){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		list2.add(random.nextInt(100));
		}
	}

	public void process() {

		for (int i = 0; i < 1000; i++) {

			addInList1();

			addInList2();
		}

	}

	public void startProcessing() {

		System.out.println("Process Starts");

		long start = System.currentTimeMillis();

		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
				
				process();
				
			}
			
		});
		
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {
				
				process();
				
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
		
		long end = System.currentTimeMillis();

		System.out.println("Process Ends. Time Taken : " + (end - start));

		System.out.println("Size of List1 : " + list1.size() + " ; Size of List2 : " + list2.size());

	}

	public static void main(String args[]) {

		IntrinsicLock lock = new IntrinsicLock();

		
		lock.startProcessing();
	}
}
