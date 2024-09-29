abstract class Parent {
	
	public abstract void show(); // can have both abstract and non-abstract methods
	
	public void show1() {
		System.out.println("Showing 1");
	}
	public final void show2() { // can also have final method
		System.out.println("Showing 2");
	}
}

class Child1 extends Parent{
	@Override
	public void show() { //all child should implement the abstract class
		System.out.println("Showing 1 by c1");
	}
//	public void show2() { // cannot modify since it is final
//		System.out.println("Showing 2");
//	}
	
}

class Child2 extends Parent{
	@Override
	public void show() { //all child should implement the abstract class
		System.out.println("Showing 1 by c2");
	}
}

abstract class Child3 extends Parent{
	public void show3() {
		System.out.println("Showing 3 by c3");
	}
} //all child should implement the abstract class unless child is an abstract class 

public class Abstraction {

	public static void main(String[] args) {
//		Parent object = new Parent(); // not possible to create reference of abstract class type

		Child1 obj1 = new Child1();		
		obj1.show();
		obj1.show1();
		obj1.show2();
		
		Child2 obj2 = new Child2();
		obj2.show();
		obj2.show1();
		obj2.show2();
		
		Parent obj3 = new Child2(); // this is possible because the object is up-casted to abstract type class	
		obj3.show(); 
		obj3.show1();
		obj3.show2();
//		obj3.show3();// not possible because the obj3 is up-casted to parent type
//		             // if up-casted to parent type then the methods that override the parent can only be called
		
	}

}
