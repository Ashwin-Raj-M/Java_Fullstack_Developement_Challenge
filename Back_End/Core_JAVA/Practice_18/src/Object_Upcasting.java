/**
 * Object are basically dayatypes hece type casting is possible
 * 
 * Upcasting is the process of assigning a child class object to a parent class reference,
 * this alows us to access all the datamembers and methodes from the parent class while it
 * only allowa overriding methodes from the child class to be called and 
 * no data members from the child class could be accessed. F the datamembers ar same as parent 
 * class the parent class value will be displayed.
 * 
 * This takes place implicitly (automatically)
 * 
 * Also called as "Widening" or "Generalization" or "Implicit casting".
 * 
 * @author ashwi
 *
 */

import Requirements.*;

public class Object_Upcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal obj = new Cat(); // the cat type object is implicity upcasted to Animal type
		Cat obj1 = new Cat();
		
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
