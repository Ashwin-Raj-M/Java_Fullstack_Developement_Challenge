package Run_Time_Polymorphism;

class OverridenClass4{
		
	public void show1() {
		System.out.println("Show method 1.0");
	}
	
	private void show2() {
		System.out.println("Show method 2.0");
	}
	
	public final void show3() {
		System.out.println("Show method 3.0");
	}
	
	public static void show4() {
		System.out.println("Show method 4.0");
	}
	
}

class OverridingClass4 extends OverridenClass4{
	
	@Override 
	public void show1() { // normal overriding
		System.out.println("Show method 1.1");
	}
	
//	@Override 
//	public void show2() { // overriding will not work with private methodes
//		                  // because the privte method is not visible to the child class
//		                  // child class cosiders the overriding meythod as a different method unless the @Override is used
//		System.out.println("Show method 2.1");
//	}
	
//	@Override 
//	public void show3() { // overriding will not work with final methodes
	                      // because the method body coulds not be changed for a final method
//		System.out.println("Show method 3.1");
//	}

//	@Override 
//	public void show4() { // overriding will not work with private methodes
	                      // because the static methodes belong to the class and not to any specific instance
	                      // hence doesnot participate in overriding 
	                      // (statically bound to the class) ie:- resolved during the compile time while overriding is runtime phenominon
//		System.out.println("Show method 3.1");
//	}

}

public class Overriding_Not_Work {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverridenClass2 obj1 = new OverridingClass2();
		obj1.show1();
		obj1.show2();
		obj1.show3();
//		obj1.show4(); // will not work snice, the reference is upcasted, which allow only the overriding methodes in the child class
					  // as already mentioned, the show4() class is considered as a different method in subclass
 		
		OverridingClass2 obj2 = new OverridingClass2();
		obj2.show4(); // works because java does not see the parent method and directly locates show4() in the child class
	} 
}