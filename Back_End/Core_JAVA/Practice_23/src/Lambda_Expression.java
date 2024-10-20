/**
 * Lambda expressions are introduced in java 8, it is only applicable with functional interfaces.
 * Characteristics of Lambda Expressionas:
 * makes the code shorter
 * unlike Anonymoys inner class lambda expressions dosenot create a class file
 * lambda functions could also be passed as arguments
 * 
 * !! individually uncomment the code and to further understand
 * 
 * @author ashwi
 *
 */

@FunctionalInterface
interface FunInter1{
	void show();
}

interface FunInter2{
	void show(int n);
}

interface FunInter3{
	int show(int n1, int n2);
}

public class Lambda_Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		// usually we use Anonymous Inner class to override the methodes of abstract class or interface 
//		FunInter1 obj = new FunInter1() {
//			public void show() {
//				System.out.println("Shows");
//			}
//		};
		
		//could be writtern as lambda expression
//		FunInter1 obj = () -> {
//				System.out.println("Shows");
//			};		
	
		// Since it has only one statement could further be shortened as
		FunInter1 obj = () -> System.out.println("Shows");
		obj.show();
		
		
		//when it has arguments				
//		FunInter2 obj1 = new FunInter2() {
//			public void show(int n) {
//				System.out.println("Shows" + " " + n);
//			}
//		};
		
		//could be writtern as lambda function
//		FunInter2 obj1 = (int n) -> {
//				System.out.println("Shows" + " " + n);
//		};
		
		// Since it has only one statement could further be shortened as
//		FunInter2 obj1 = (int n) -> System.out.println("Shows" + " " + n);
		
		//could further be shortened as
//		FunInter2 obj1 = (n) -> System.out.println("Shows" + " " + n); 
		// since the vaiable type is defined in the interface itself
		
		//if only one aargument is used could further be shortened as
		FunInter2 obj1 = n -> System.out.println("Shows" + " " + n); 
		obj1.show(5);
	
		// if the interface has arguments and return type
//		FunInter3 obj2 = new FunInter3() {
//			public int show(int n1, int n2) {
//				return n1 + n2;
//			}
//		};
		
		// could be wrttern as a lambda function
//		FunInter3 obj2 = (int n1, int n2) -> {
//				return n1 + n2;
//		};
		
		// Since it has only one statement could further be shortened as
//		FunInter3 obj2 = (int n1, int n2) -> return n1 + n2; // the return statement should not be added
		//hence writtern as
//		FunInter3 obj2 = (int n1, int n2) -> n1 + n2;
		
		//could further be shortened as
		FunInter3 obj2 = (n1, n2) -> n1 + n2;
		// since the vaiable type is defined in the interface itself
		
		System.out.println(obj2.show(5, 10));
	}
}