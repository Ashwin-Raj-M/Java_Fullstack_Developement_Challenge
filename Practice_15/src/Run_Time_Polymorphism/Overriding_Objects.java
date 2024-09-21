package Run_Time_Polymorphism;

class OverridenClass1{
	
	int num = 10;
	
	public void show() {
		System.out.println("Show method 0");
	}
}

class OverridingClass1 extends OverridenClass1{
	
	int num = 20;
	
	@Override // annotation to tell compiler that it is a overriding method, helpfull when we make a spelling mistack in the method name
	          // this can be checked by changing the name of the overriding maethod name, before and after addng annotation
	public void show() {
		System.out.println("Show method 1");
	}
}

public class Overriding_Objects {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverridingClass1 obj1 = new OverridingClass1();
		obj1.show(); // calls the method in the overriding class (overriding happens)
		System.out.println(obj1.num); // calls the num of the over 
		
		OverridenClass1 obj2 = new OverridenClass1();
		obj2.show(); // calls the method in the overriden class (no overriding happens)
					 // this is because the parent class neve know that it has a child
		System.out.println(obj2.num);
		
		OverridenClass1 obj3 = new OverridingClass1();
		obj3.show(); // calls the child class method since the methods are located throught the type of the object itself 
		System.out.println(obj3.num); // calls the num of parent class
									  // since the datamembers are located thorugh the typr of the reference
		                              // So, overriding will not work with Data members
	}

}
