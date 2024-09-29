package Run_Time_Polymorphism;


class OverridenClass2{
		
	void show1() {
		System.out.println("Show method 1.0");
	}
	
	public void show2() {
		System.out.println("Show method 2.0");
	}
	
	protected void show3() {
		System.out.println("Show method 3.0");
	}
	
	private void show4() {
		System.out.println("Show method 4.0");
	}
	
	public void show() {
		show4();
	}
	
}

class OverridingClass2 extends OverridenClass2{
	
	@Override 
	public void show1() { // will not work when the method is called or overriden from out of the package
		System.out.println("Show method 1.1");
	}
	
	@Override 
	public void show2() { // overriding will always work with public access
		System.out.println("Show method 2.1");
	}
	
	@Override 
	public void show3() { // will not work when the method is called or overriden from out of the package unless it is a subclass
		System.out.println("Show method 3.1");
	}
	
//	@Override 
//	private void show4() { 	// overriding will not work since private methodes coaanot be accessed by the child 
//		System.out.println("Show method 4.1");
//	}
	
	// to call the private method of a parent class , "invoking parent class method from subclass method" can be used
	
	public void show4() { // here the child class does not know that the parent class has show4() hence considered a different method
		                  // hence no overriding happens and no errors unless @Overiride is used
	super.show();
	} 

}

public class Overriding_AccessModifiers {
	
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
