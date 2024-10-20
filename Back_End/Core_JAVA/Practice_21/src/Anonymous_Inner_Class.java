/***
 * Anonymous inner classes are created to implement a specific behaviour just once, 
 * that it is not worth creating a new class.
 * 
 * "Here I have explained its use by overriding the show method, the only purpose of the 
 * anonymus inner class is to create a method that override the Show methid in the Testclass only once."
 * 
 * characteristics of Anonymous inner class:
 * JVM will create a class file for Anonymous inner class named "here" Anonymous_Inner_Class$1.clsss
 * Anonymous inner calss could be used to implement methodes of Abstract class
 * 
 * @author ashwi
 *
 */

class TestClass{
	
	public void show() {
		System.out.println("This is TestClass");
	}
	
}

abstract class AbstractClass{
	
	public abstract void show(); // abstract method
	
}

public class Anonymous_Inner_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass out1 = new TestClass();
		out1.show(); // this object will implement the behavious defined in the TestClass
		
		
		// OuterClass object and Anonymous innerclass creation
		TestClass out = new TestClass() {
			public void show() {
				System.out.println("This is AnonymousClass of TestClass");
			}
		};
		out.show(); // this object will implement the behavious defined in the Anonymous class of TestClass
		
		
		AbstractClass out2 = new AbstractClass() { // the only purpose is to implement abstract method
			public void show() {
				System.out.println("This is AnonymousClass of AbstractClass");
			}
		};
		out2.show(); // this object will implement the behavious defined in the Anonymous class of AbstractClass
	}
}