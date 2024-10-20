/**
 * 
 * Using the priority and sleep, we can only suggest the scheduler to approach in a certain way, but we can never control the scheduler
 * The priority range of Threads is (1 through 10)
 * 
 * @author ashwi
 *
 */

class A1 extends Thread{ // Since we are extending Threads we cant exted any other classes for inheritance.
						 // Instead we can implement Runnable Interface.(Explained in Best_Practice.java)
	public void  run() {
		for(int i = 0; i < 100; i ++) {
			System.out.println("hi");
			try {
				Thread.sleep(10);// this method could throw a Interrupted Exception. 
								 // Hence should be enclosed by try catch and "throws" will not work with threads
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}

class B1 extends Thread{ 
	public void  run(){
		for(int i = 0; i < 100; i ++) {
			System.out.println("hello");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Thread_Priority_Sleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A1 obj1 = new A1();
		B1 obj2 = new B1();
		
		obj1.getPriority(); // by default the priority of all the threads are 5
		
		/* There are some default Priority constants : 
				MAX_PRIORITY = 10
				NORM_PRIORITY = 5
				MIN_PRIORITY = 1
		*/
		obj1.setPriority(5);
		obj2.setPriority(Thread.MAX_PRIORITY); // here we are suggestion the scheduler to give 
											   // maximum priority to the B1 thread
											   // there is no guarantee that the scheduler will prioritize accordingly
		
		obj1.start(); 
		obj2.start();

	}

}
