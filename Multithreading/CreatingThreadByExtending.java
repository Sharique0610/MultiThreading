package Multithreading;

public class CreatingThreadByExtending extends Thread{

	public void run(){
		
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
		
		CreatingThreadByExtending thread1=new CreatingThreadByExtending();
		
		thread1.start();
		
		CreatingThreadByExtending thread2=new CreatingThreadByExtending();
	
		thread2.start();;
	}
}
