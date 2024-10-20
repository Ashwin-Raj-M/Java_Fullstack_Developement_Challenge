/**
 * 
 * @author ashwi
 *
 */

//Here the only purpose of class A and B is to implement Runnable Interface. Hence could be made as lambda expressions. 

class A2 implements Runnable{
	public void  run() {
		for(int i = 0; i < 100; i ++) {
			System.out.println("hi");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}

// Runnable is a Functional interface with only the run() abstract method.

class B2 implements Runnable{ 
	public void  run(){
		for(int i = 0; i < 100; i ++) {
			System.out.println("hello");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Best_Practice {

	public static void main(String[] args) {
		
//		A2 obj1 = new A2();
//		B2 obj2 = new B2();
		
//		They could also be upcasted since they implement the Runnable Interface
		Runnable obj1 = new A2();
		Runnable obj2 = new B2();
		
		
//		obj1.start(); 
//		obj2.start();
//		These wont work since the Class A and B implements Runnable Interface Which is being implemented by the Thread class
//		hence class A and B does not have start() method, since start method is a method of Thread class
//		To overcome this we can creat objects of Thread Class and pass the objects of A and Bas arguments to Cinstructor of Thread
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start(); 
		t2.start();

	}

}
