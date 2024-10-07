/**
 * Object are basically dayatypes hece type casting is possible
 * 
 * Down casting of a direct parent class object is not possiblee in java. A cupcasted child 
 * class object could be down casted to child class again, which again allows complete acces of the
 * child class unlike upcasted child class object.
 * 
 * This should be done explicitly (mannualy)
 * 
 * Also called as "Narrow Casting" or "Explicit casting".
 * 
 * @author ashwi
 *
 */

import Requirements.*;

public class Object_Downcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
//		Cat obj0 = new Animal(); // not possible since the animal class have no ide of the cat class
		
		Animal obj = new Cat(); // the cat type object is implicity upcasted to Animal type
		Cat obj1 = (Cat) obj;
		
		obj.sound();
		obj1.sound();
		
//		obj.color(); // this could not be called
		obj1.color(); // will work
		
		System.out.println(obj.food);
		System.out.println(obj1.food);
		
//		System.out.println(obj.age); // will not work
		System.out.println(obj1.age);
	}

}
