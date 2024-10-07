/**
 * Wrapper classes are used to convert primitive datatype to object and viceversa
 * all primitive datatypes have their corresponding wrapper classes
 * 
 * primitive to object --> autoboxing
 * object to primitive --> unboxing
 * 
 * @author ashwi
 *
 */

public class Wrapper_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Autoboxing
		int n = 5;
		Integer num = n; // automatically converted int type into a Integer class type
		Integer num1 = Integer.valueOf(n); // mannual method of converting nt type into a Integer class type
		                                   // here .ValueOf() is a static method in Integer class
										   // usually used in collections where the integers values added 
		                                   // to the collections like arraylist, hash set because they store objects
		
		// Unboxing
		Integer in = new Integer(5);
		int in1 = in; // automatically converted into primitive type
		int in2 = in.intValue(); // mannual method of converting Integer class type into int.
		                         // here .intValue is instance methode of Integer Class
		
	}

}
