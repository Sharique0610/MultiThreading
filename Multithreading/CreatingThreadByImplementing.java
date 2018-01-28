package Multithreading;

public class CreatingThreadByImplementing implements Runnable {

	@Override
	public void run() {
	
	for(int i=0;i<10;i++){
			
			System.out.println("Print Thread "+i+"  Thread Name "+Thread.currentThread().getName());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String args[]){
		
		Thread thread1=new Thread(new CreatingThreadByImplementing());
		
		thread1.start();
		
		Thread thread2=new Thread(new CreatingThreadByImplementing());
		
		thread2.start();
		
	}

}
