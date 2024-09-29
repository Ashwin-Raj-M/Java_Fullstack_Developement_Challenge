
public class MultiDimArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[2][3]; //multi-dimensional array declaration and instantiation
		
		for(int[] i : arr) { // stores default value "0"
			for(int j : i) {
				System.out.print(j + " ");
			}
		}
//		arr = {{1, 2, 3}, {4, 5, 6}};// not possible
		int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6}}; //multi-dimensional array declaration, instantiation and initialization

		for(int[] i : arr1) { // stores default value "0"
			for(int j : i) {
			System.out.print(j + " ");
			}
		}
	}
}
