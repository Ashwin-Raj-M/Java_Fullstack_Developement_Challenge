/**
 * User define Exceptions are used to create Exceptions for costum purposes
 * this user defined exceptions are usually created as a child class of the class "Exception"
 * @author ashwi
 *
 */
class SampleException extends Exception {
	
	public SampleException() {} // default constructor
	
	public SampleException (String s) {
		super(s); // the custom string is sent to the constructor of the super class of this class is:- Exception class
		          // from there the string message is returned to the catch along with the exception type (ie:- SampleException)
	}
}

public class Exception_User_Defined {
	
	public static void main(String args[]) {
		int a = 20;
		try {
			if(a < 25) {
				throw new SampleException("Hi Exception!..");
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());// can be used to extract only the message sent while throwing
		}
	}
	
}