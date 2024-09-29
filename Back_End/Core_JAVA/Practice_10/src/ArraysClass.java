
public class ArraysClass {
	
	public int[] arrTest(int[] arr) { // array could bes passed as argument 
		for(int i : arr) {// foe each loop, works based on the values and not on index
			System.out.print(i + " ");	
		}
		System.out.print("\n");
		return new int[]{1,3, 5, 7};// array could be returned
									// Anonymous array is also possible in java
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr; // array declaration
		arr = new int[2]; // array instantiation
		arr[0] = 1;
		arr[1] = 2;// array initialization
		
		ArraysClass obj = new ArraysClass();
		
		int arr0[] = obj.arrTest(arr);
		
		for(int i : arr0) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
		
		int[] arr1 = {1, 2 , 3, 4}; // array declaration and initialization
		int[] arr2 = new int[] {1, 2, 3, 4};// also declaration and initialization
		
		System.out.println(arr1);// prints the initial address of the array
		System.out.println(arr2);
		
		for(int i : arr1) {// foe each loop, works based on the values and not on index
			System.out.print(i + " ");
		}
	}

}
