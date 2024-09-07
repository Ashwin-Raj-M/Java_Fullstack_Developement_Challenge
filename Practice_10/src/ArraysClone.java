/**
 * Array in java implements a interface called cloneable hence allows deep and shallow cloning
 * @author ashwi
 *
 */


public class ArraysClone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[] {1, 2, 3, 4};
		
		int[] arr2 = arr1.clone(); // creates a clone of arr1 and stores in arr2
		
		// checking if both the objects are same
		System.out.println(arr1 == arr2); // prints false, hence the are different objects
	}

}
