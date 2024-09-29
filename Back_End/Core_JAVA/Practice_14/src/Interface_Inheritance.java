
/**
 * Interface is a blueprint of a class and it contains only Static constants and
 * abstract methods by default
 * 
 * @author ashwi
 *
 */

interface Printable {
	int MIN = 5; // --> public static final int MIN = 5;

	void print(); // --> public abstract void print();
					// cannot define the method since it is a abstract method by default

}

class Printing implements Printable {
	public void print() { // shows error if we do not mention access specifier because it will be
							// considered as default, but it if public in interface by default
		System.out.println("Printing"); // should implement the class
	}

	public void print1() { 
		System.out.println("Printing1"); 
	}
}

public class Interface_Inheritance {
	public static void main(String arg[]) {
		Printing obj1 = new Printing();
		Printable obj2 = new Printing();
		obj1.print();
		obj2.print();
//		obj2.print1();	will not work because of up-casting
	}
}
