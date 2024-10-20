
/**
 * Collections belongs to java.util package
 * all the collections take object type as default hence wrapper classes are used
 * List supports index
 * 
 * @param args
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Collection_List {

	public static void main(String[] args) {
		
		Collection <Integer> arr = new ArrayList<Integer>(); // upcasted to collection
		arr.add(1); // here auto-boxing takes place
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		
//		System.out.println(arr.get(2));// will not work since the collection interface doecnot have get calss and ArrayList is upcasted to Collection
		
		System.out.println(arr);
//		for(Object num : arr) {
//			System.out.println(num);
//		}
		
		System.out.println();
		for(int num : arr) { // here auto-unboxing takes place
			System.out.println(num);
		}
		
		System.out.println();
		//collection doesnot work based on indexing, so List or Array list could be used instead of upcasting to Collection
		
		List <Integer> arr1 = new ArrayList<Integer>(); // upcasted to collection
		arr1.add(11); // here auto-boxing takes place
		arr1.add(12);
		arr1.add(13);
		arr1.add(14);
		arr1.add(15);
		arr1.add(16);
		
		System.out.println(arr1);
		
		System.out.println();
		
		System.out.println(arr1.get(2));
		
		System.out.println();
		
		for(int num : arr1) { // here auto-unboxing takes place
			System.out.println(num);
		}
		
	}
}