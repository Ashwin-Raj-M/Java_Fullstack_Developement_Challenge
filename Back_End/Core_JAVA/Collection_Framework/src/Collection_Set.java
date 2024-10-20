
/**
 * Collections belongs to java.util package implements a interface called Iterable.
 * all the collections take object type as default hence wrapper classes are used
 * Set doesnot supports index
 * values will be randomized
 * Does not allow duplicate values
 * 
 * @param args
 */

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class Collection_Set {

	public static void main(String[] args) {
		
		Set <Integer> arr1 = new HashSet<Integer>();
		arr1.add(51); 
		arr1.add(12);
		arr1.add(73);
		arr1.add(44);
		arr1.add(15);
		arr1.add(15); // even if we add duplicates it the value will not be added 
		
		System.out.println(arr1);
		
//		System.out.println(arr1.get(2)); // will not work with set since the values will be randamized
		
		System.out.println();
		
		for(int num : arr1) { 
			System.out.println(num);
		}
		
		Set <Integer> arr2 = new TreeSet<Integer>(); // TreeSet has the values sorted
		arr2.add(51); 
		arr2.add(12);
		arr2.add(73);
		arr2.add(44);
		arr2.add(15);
		arr2.add(15); 
		
		System.out.println(arr2);
		
		System.out.println();
		
		for(int num : arr2) { 
			System.out.println(num);
		}
		
		Set <Integer> arr3 = new TreeSet<Integer>(); 
		arr3.add(51); 
		arr3.add(12);
		arr3.add(73);
		arr3.add(44);
		arr3.add(15);
		arr3.add(15); 
		
		System.out.println();
		
		// Since Set implements Iterable, it has a method calledd itrable
		
		Iterator<Integer> values = arr3.iterator(); // the iterator method returns a Iterator object
		
		// The Iterator class has next() and hasNext() methodes
		
		while(values.hasNext()) {
			System.out.println(values.next());
		}

	}
}