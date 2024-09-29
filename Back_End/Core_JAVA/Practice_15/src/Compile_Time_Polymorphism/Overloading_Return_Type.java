/**
 * Compile Time Polymorphism will not work based on Return Datatype of parameter
 */

package Compile_Time_Polymorphism;

public class Overloading_Return_Type {
	
	public void show(int a, int b) {
		System.out.println("Show method " + a + " " + b);
	} 
	
//	public int show(int a, int b) {
//		return a+b;
//	}
			
//  all three methodes ar considered as different methodes and are 
//	called based on the arguments passed when calling
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overloading_NOP obj = new Overloading_NOP();
		
		obj.show();
		obj.show(2);
		obj.show(3, 4);
		
//		All these three methides callings, executes differet behaviours 
//		as the call different methodes of same name which is called as methode overloading 
		
	}

}
