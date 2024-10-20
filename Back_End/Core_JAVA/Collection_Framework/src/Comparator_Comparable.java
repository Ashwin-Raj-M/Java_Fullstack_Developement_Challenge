import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator is a abstract class and Comparable is functional interface
 * 
 * @author ashwi
 *
 */
class Students {
	String name;
	int age;
	
	public Students(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", age=" + age + "]";
	}
}

class Students1 implements Comparable <Students1>{
	String name;
	int age;
	
	public Students1(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Students1 that) {
		// TODO Auto-generated method stub
		return (this.age > that.age) ? 1 : -1;
	}

	@Override
	public String toString() {
		return "Students1 [name=" + name + ", age=" + age + "]";
	}
}	

public class Comparator_Comparable {

	public static void main(String[] args) {
		
		List <Integer> arr1 = new ArrayList<Integer>(); // upcasted to collection
		arr1.add(91);
		arr1.add(24);
		arr1.add(72);
		arr1.add(45);
		arr1.add(13);
		arr1.add(66);
		
		// Collections is a class with multiple mathodes
		Collections.sort(arr1); // sort methodes sorts the Integer class type 
		
		System.out.println(arr1);
		
//		if we want to sort by only the last digit
		
		Comparator <Integer> com1= new Comparator <Integer>() {
			@Override
			public int compare (Integer i, Integer j){
				return (i%10 > j%10) ? 1 : -1;
			}

		};
		
		Collections.sort(arr1, com1); // here to change the logic the sort method requires a Comparator object
		
		System.out.println(arr1);
		
		
		List <Students> arr2 = new ArrayList<Students>(); // upcasted to collection
		arr2.add(new Students("Ashwin", 100));
		arr2.add(new Students("Aparnaa", 98));
		arr2.add(new Students("Marimuthu", 99));
		arr2.add(new Students("Uma", 95));
		
//		if we want to sort list by length of the name of the students
		
		Comparator <Students> com2= new Comparator <Students>() {
			@Override
			public int compare (Students i, Students j){
				return (i.name.length() % 10 > j.name.length() % 10) ? 1 : -1;
			}
		};
		
		Collections.sort(arr2, com2); // here to change the logic the sort method requires a Comparator object
		
		for(Students s : arr2) {
			System.out.println(s);
		}
		
		System.out.println();
		
//		What id we need to sort the students without any comparator and make it sort naturallly like Integer
		
		List <Students1> arr3 = new ArrayList<Students1>(); // upcasted to collection
		arr3.add(new Students1("Ashwin", 100));
		arr3.add(new Students1("Aparnaa", 98));
		arr3.add(new Students1("Marimuthu", 99));
		arr3.add(new Students1("Uma", 95));
		
		Collections.sort(arr3); // this work now since the Student1 class implements the Comaprable interface like Integer class.
		
		for(Students1 s : arr3) {
			System.out.println(s);
		}
	}
}
