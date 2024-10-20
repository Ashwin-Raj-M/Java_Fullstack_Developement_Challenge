/**
 * Since the only purpose of the classes A and B where to implement the Runnable interface once,
 * hence we can write them as lambda expressions.
 * @author ashwi
 *
 */

public class Thread_Lambda_Expression {

	public static void main(String[] args) {
		
//		Here the Lambda expression overrides the run() method in Runnable Interface
		Runnable obj1 = () -> {
			for(int i = 0; i < 100; i ++) {
				System.out.println("hi");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		};
		Runnable obj2 = () -> {
			for(int i = 0; i < 100; i ++) {
				System.out.println("hello");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start(); 
		t2.start();

	}

}