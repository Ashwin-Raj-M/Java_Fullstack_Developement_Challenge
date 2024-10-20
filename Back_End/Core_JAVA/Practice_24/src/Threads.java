/**
 * Threads is a class in java and is used to implement parallel processing.
 * Every thread should have a run() which will be executed when Start() is called.
 * The Threads work by a concept called "Time Sharing", where the "Scheduler" schedules the turn of each thread
 * 
 * @author ashwi
 *
 */

class A extends Thread{ // to make a class thread it should extend the Thread Class
	public void  run() {
		for(int i = 0; i < 100; i ++) {
			System.out.println("hi");
		}
	}
}

class B extends Thread{ // to make a class thread it should extend the Thread Class
	public void  run() {
		for(int i = 0; i < 100; i ++) {
			System.out.println("hello");
		}
	}
}

public class Threads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A obj1 = new A();
		B obj2 = new B();
		
		obj1.start(); 
		obj2.start();
		
		// the output will be un uniforn because the threads executed as much 
		// as prints in the time allocated by the scheduler, then the next the next
		// thread is starts. This process goes on until the process of both threads are completed.
	}

}
