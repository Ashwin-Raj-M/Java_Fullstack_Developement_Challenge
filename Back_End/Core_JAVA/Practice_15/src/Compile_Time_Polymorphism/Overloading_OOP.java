/**
 * Compile Time Polymorphism based on Order of parameter
 */

package Compile_Time_Polymorphism;

public class Overloading_OOP {
	public void show() {
		System.out.println("Show method 0");
	}
	
	public void show(int a, float b) {
		System.out.println("Show method " + a + " " + b);
	} 
	
	public void show(float a, int b) {
		System.out.println("Show method " + a + " " + b);
	}
			
//  all three methodes ar considered as different methodes and are 
//	called based on the arguments passed when calling
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overloading_OOP obj2 = new Overloading_OOP();

		obj2.show(2, 3.2f);
		obj2.show(5.3f, 4);
		
//		All these three methides callings, executes differet behaviours 
//		as the call different methodes of same name which is called as methode overloading 
		
	}
}
