package Multithreading;

import java.util.concurrent.atomic.AtomicBoolean;

public class PrintHelloWorld {

	public static void main(String[] args) throws InterruptedException {
       
         Runnable helloTask=new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				printHello();
			}
        	 
         };
            Runnable worldTask = new Runnable(){
                @Override
                public void run(){
                    printWorld();
                }
            };

            Thread t1 = new Thread(helloTask);
            Thread t2 = new Thread(worldTask);
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        }

	public static void printHello() {
		// synchronized (hello) {
		System.out.print("Hello ");
		// }
	}

	public static void printWorld() {
		// synchronized (world) {
		System.out.println("World");
		// }
	}
}
