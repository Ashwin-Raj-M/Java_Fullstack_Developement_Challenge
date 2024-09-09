
public class ObjectArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TempClass arr[] = new TempClass[3];
		arr[0] = new TempClass("Ashwin");
		arr[1] = new TempClass("Raj");
		arr[2] = new TempClass("Mari");
		
		TempClass arr1[] = arr.clone();
		
		System.out.println(arr == arr1);// false because it creates a new array with elements pointing to the same objects
		System.out.println(arr[0] == arr1[0]);//true because the elements of the cloned array also points to the same objects
		System.out.println(arr[1] == arr1[1]);
		System.out.println(arr[2] == arr1[2]);
	}

}
