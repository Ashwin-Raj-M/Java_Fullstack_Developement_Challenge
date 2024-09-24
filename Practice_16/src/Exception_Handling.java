/**
 * Exception handling basics
 * a exception throws a exception type object which terminates the program 
 * hecne the the catch block is used to catch the thrown exception
 * @author ashwi
 *
 */

public class Exception_Handling {

	public void test() throws ArithmeticException { // throws is used to declare that, 
        // the method may return a Exception
		int num = 5 / 0;
		System.out.println(num);// will not be excuted
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*1*/	try {
			int num = 5 / 0; // in java divition by '0' is not possible
		}
		// System.out.print("hello"); // try and catch block should always be concecutive, this line may cause error
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		
/*2*/	try {
			String s = null;
			int l = s.length(); // null string reference cannot be used for calling methodes
			System.out.println("This will not be executed"); // line after the exceptional line will be skiped, 
			                                                 // hence only the excetion causing lines should be wraped by try{}
		}
		catch(NullPointerException e) {
			System.out.println(e);
		}
		
/*3*/	try {
			try { // nested try{}s are possible
					String s1 = "abc";
					int l1 = Integer.parseInt(s1); // parseInt cannot convert character string to numbers
			}
			catch(NumberFormatException e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
/*4*/	try {
			int[] a = new int[5];
			a[5] = 10/0;
		}
		catch(ArrayIndexOutOfBoundsException e) { // occurs when index out of the size of the array is accessed or travased
			System.out.println(e);
		}
		catch(ArithmeticException e) { // single try could have multiple catch statements
			System.out.println(e);
		}
		
/*5*/	try {
			String s1 = "abc";
			char c = s1.charAt(3);
		}
		catch(StringIndexOutOfBoundsException e) { // occurs when index out of the size of the array is accessed or travased
			System.out.println(e);
		}

		int a = 20;
/*6*/	try {
			if(a == 20) {
				throw new ArithmeticException("Just Exception"); // exceptions could be mannualy throwed through throw keyword
			}
		}
		catch(ArithmeticException e) { // occurs when index out of the size of the array is accessed or travased
			System.out.println(e);
		}

		Exception_Handling obj = new Exception_Handling();
/*7*/	try {
			obj.test(); // the throws a exception which is from the 
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		finally { // this block will be excuted regardless of the exception occerance
			      // hence used to close DBs and Files for protection
			System.out.println("Finally executed");
		}

	}

}
