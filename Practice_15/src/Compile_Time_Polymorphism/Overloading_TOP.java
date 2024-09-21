/**
 * Compile Time Polymorphism based on Datatype of parameter
 */


package Compile_Time_Polymorphism;

public class Overloading_TOP {

	public void show(int a) {
		System.out.println("Show method 0");
	}
	
	public void show(float a) {
		System.out.println("Show method " + a);
	} 
			
//  all three methodes ar considered as different methodes and are 
//	called based on the arguments passed when calling
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overloading_TOP obj1 = new Overloading_TOP();
		
		obj1.show(5);
		obj1.show(3.4f);
		
//		All these three methides callings, executes differet behaviours 
//		as the call different methodes of same name which is called as methode overloading 
		
	}
}
