/**
 * Java allows multiple inheritance through INterfaces
 * java 8 allows default and static methods in interfaces
 * java 9 allows private methods
 * @author ashwi
 *
 */

interface Printables1{
	void print();
	default void test() {
		System.out.println("testing1");
	}
}

interface Showable1{
	void show();
	void print();
//	default void test() {
//		System.out.println("testing2");
//	}
}

class ImplementationClass1 implements Printables1, Showable1{
    // the child most class should implement all the methods of all the parent interfaces
	public void show() {
		System.out.println("show");
	}

	public void print() {
		System.out.println("print");
	}
	
}

public class Interface_MultipleInheritance {

	public static void main(String[] args) {
		
		ImplementationClass1 obj = new ImplementationClass1();
		obj.print();
		obj.show();
		obj.test();
		
		Printables1 obj1 = new ImplementationClass1();
		obj1.print();
		obj1.test();
//		obj1.show(); // will not work because is of other interface
		
		Showable1 obj2 = new ImplementationClass1();
//		obj2.print(); // will not work because is of other interface
		obj2.show();
//		obj2.test(); // will not work because the showable does not have it
	}

}