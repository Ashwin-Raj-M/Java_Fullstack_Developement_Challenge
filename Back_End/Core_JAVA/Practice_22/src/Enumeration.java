/***
 * Enums are named conatants, and are treated as a class in java
 * so it allows object creation, constructors, method declaration and even variables
 * !! But enums cannot be extended by any other classes
 * 
 * all enums extends the Enum Class by default.
 * 
 * @author ashwi
 *
 */

enum Status{ // Extends the Enum class by default 
	Running, Compiling, Debugging, Success; // these are objects of the Status enum and are the named constatnts
											// hece private constructors are allowed.
										    // each named constants have its own ordinals ie:- numbering, 
                                            // in java it starts fron 0 by default
}


public class Enumeration {	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Status s1 = Status.Running;
		
		System.out.println(s1.getClass());
		System.out.println(s1.getClass().getSuperclass());  // this proves that the Status extends the Enum class
		
		System.out.println(s1);  // prints the name of that constant
		System.out.println(s1.ordinal());  // prints the numbering of that constant
		
		Status[] ss = Status.values(); // this method returns a array of type Status 
									   //containing all the named constants
		
		for(Status s : ss) {
			System.out.println(s + " : " + s.ordinal());
		}
		
		// Enum works with if else and Switch
		
		switch (s1){
			case Running: // we dont have to mention like this Status.Running, 
						  // because switch know that is a enum when passed with a enume object
				          // but in if else you have to mention in the conventional way ie:- "Status.Running"
				System.out.println("All Good");
				break;
				
			case Compiling:
				System.out.println("Wait");
				break;
				
			case Debugging:
				System.out.println("Correcting");
				break;
				
			default:
				System.out.println("All done");
				break;
		}
//		This could be very usefull in handling errors for example "404 pagen not found" and other server errors
	}

}
