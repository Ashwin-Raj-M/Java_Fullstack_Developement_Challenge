/***
 * JVM will create a class file for inner class named "here" OuterClass$InnerClass.clsss
 * @author ashwi
 *
 */


//static class OuterClass{ // It is not possible to make a outer class static
class OuterClass{
	
	public void showOuter() {
		System.out.println("This is Outer Class");
	}
	
	class InnerClass{
		
		public void showInner() {
			System.out.println("This is Inner Class");
		}
		
	}
	
	static class StaticInnerClass{ // This allows us to access this class wwith outer class name.
		
		public void showStaticInner() {
			System.out.println("This is Static Inner Class");
		}
		
	}
}


public class Inner_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// OuterClass object Creation
		OuterClass out = new OuterClass();
		out.showOuter();
		
		// Standard InnerClass object Creation
		OuterClass.InnerClass in = out.new InnerClass();
		in.showInner();
		
		// Standard InnerClass object Creation
		OuterClass.StaticInnerClass statIn = new OuterClass.StaticInnerClass();
		statIn.showStaticInner();
		

	}

}
