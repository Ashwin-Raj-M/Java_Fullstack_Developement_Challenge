package Compile_Time_Polymorphism;

public class Overloading_Type_Conversion {

	
	public void show(byte a) {
		System.out.println("Show method 1 " + a);
	} 
	
	public void show(short a) {
		System.out.println("Show method 2 " + a);
	} 
	
	public void show(int a) {
		System.out.println("Show method 3 " + a);
	} 
	
	public void show(long a) {
		System.out.println("Show method 4 " + a);
	} 
	
//	public void show(float a) {
//		System.out.println("Show method 5 " + a);
//	} 
	
//	public void show(char a) {
//		System.out.println("Show method 6 " + a);
//	} 
	
	public void show(double a) {
		System.out.println("Show method 7 " + a);
	} 
			
//  all three methodes ar considered as different methodes and are 
//	called based on the arguments passed when calling
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overloading_Type_Conversion obj = new Overloading_Type_Conversion();
		
		obj.show(25600000); // calls show with int type
		obj.show('2'); // upcasted to int
		obj.show(2); // calls show with int type
		obj.show(2 / 10); //calls show with int type
		obj.show(2.3f); // upcasted to double
		

//		All these three methides callings, executes differet behaviours 
//		as the call different methodes of same name which is called as methode overloading 
		
	}

}
