interface Printables{
	void print();
}

interface Showable extends Printables{
	void show();
}

class ImplementationClass implements Showable{
    // the child most class should implement all the methods of all level of parent interfaces.
	public void show() {
		System.out.println("print");
	}

	public void print() {
		System.out.println("show");
	}
	
}

public class Interface_Multilevel {

	public static void main(String[] args) {
		
		ImplementationClass obj = new ImplementationClass();
		obj.print();
		obj.show();
		
		Printables obj1 = new ImplementationClass();
		obj1.print();
//		obj1.show(); // will not work because Printable does not have show method
		
		Showable obj2 = new ImplementationClass();
		obj2.print(); // will work because showable extends Printable
		obj2.show();
	}

}
