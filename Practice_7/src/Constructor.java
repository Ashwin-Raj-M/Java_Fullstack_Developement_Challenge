/**
 * Constructor are always called when an object of a class is created
 * Constructors returns the address of the object that is created
 * Types are default and parameterized
 * A constructor is created automatically by compiler when there is no constructor created by user
 * Constructor overloading is same as method over loading but determined by only parameters
 * @author ashwi
 *
 */

class TempClass{
	int num1;
	int num2;
	
	public TempClass (){} // default constructor
	
	public TempClass(int num1, int num2) { // parameterized constructor
		this.num1 = num1;
		this.num2 = num2;
	}
	
}

public class Constructor {
	public static void main(String arg[]) {
		
		TempClass obj = new TempClass(); // this invokes the default constructor where the instance variables
										  // are assigned with the default value for this specific object
		
		TempClass obj1 = new TempClass(2, 5); // constructor overloading
		
//		obj.num1 = 21;
//		obj.num2 = 23;
		
		System.out.println(obj1.num1);
		System.out.println(obj1.num2);
		
		System.out.println(obj.num1);
		System.out.println(obj.num2);
	}
}
