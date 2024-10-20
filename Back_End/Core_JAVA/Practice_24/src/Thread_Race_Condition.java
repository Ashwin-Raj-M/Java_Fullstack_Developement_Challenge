/**
 * Race Condition in java happens when multiple threads tries to access the method at the same time
 * This could be solved by declaring the method using synchronized keyword, this mahes the method thread safy by allowing 
 * only one thread to access the method at a time.
 * 
 * @author ashwi
 *
 */

class Race{
	int count;
	public synchronized void increase() { // synchronized keyword allows only one thread at a time to access the method
										  // try removing the Synchronized keyword for better understanding
										  // here if both the threads reaches the count method the increment may happen only once
										  // this may cause loss in count and result in wrong output.
		
		// EVEN AFTER ALL THESE PREVENTIVE MEASURES THE IS A GOOD AMOUN OF CHANCE THAT THE OUTPUT MAY BE WRONG, BECAUSE THREADS ARE UNPREDICTABLESSS
		
		this.count++;
	}
}

public class Thread_Race_Condition {

	public static void main(String[] args) throws InterruptedException {
		
		Race obj = new Race(); 
		// the threads are accessing the method of same instance of the class
		
		Runnable obj1 = () -> {
			for(int i = 0; i < 10000; i ++) {
				obj.increase();
			}
		};
		
		Runnable obj2 = () -> {
			for(int i = 0; i < 10000; i ++) {
				obj.increase();
			}
		};
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start(); 
		t2.start();
		
		t1.join(); // join method migth throw Interrupted Exception, hence it is handled by throws key word 
		t1.join();
		// join method prevents the main method from executing the "System.out.println(obj.count);" statement before the threads complete their work 
		// try commenting the join for better undersatnding
		// if commented the main method will simply execute the print statement immediately after starting the threads, since that is the only 
		// task if the main method not calling the count method.
		
		System.out.println(obj.count);

	}

}
