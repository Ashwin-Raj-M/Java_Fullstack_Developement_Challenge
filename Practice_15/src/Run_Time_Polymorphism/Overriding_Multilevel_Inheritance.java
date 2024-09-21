package Run_Time_Polymorphism;

	class OverridenClass3{
		
		void show() {
			System.out.println("Show method 0");
		}
		
	}

	class Overriding1Class3 extends OverridenClass3{
		
		@Override 
		public void show() { // will not work when the method is called or overriden from out of the package
			System.out.println("Show method 1");
		}

	}
	
	class Overriding2Class3 extends Overriding1Class3{
		
		@Override 
		public void show() { // will not work when the method is called or overriden from out of the package
			System.out.println("Show method 2");
		}

	}

	public class Overriding_Multilevel_Inheritance {
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			OverridenClass3 obj1 = new OverridenClass3();
			obj1.show(); // calls method in the parent class
			
			OverridenClass3 obj2 = new Overriding1Class3();
			obj2.show(); // calls method in the middle child class
			
			OverridenClass3 obj3 = new Overriding2Class3();
			obj3.show(); // calls method in the last child class

	}
}
