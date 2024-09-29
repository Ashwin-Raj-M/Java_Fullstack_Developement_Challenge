/**
 * Composition implements HAS-A relation ship b/w parent and Child(Example: P:Car HAS-A C:Engine)
 * @author ashwi
 *
 */

class Car {
	
	String model = "Ertiga";
	public void keyStart() {
		Engine obj = new Engine();// here the object is only created when this function is called
		obj.startEngine();
	}
	
}

class Engine {
	public void startEngine() {
		System.out.println("Started");
	}
	
	public void startStop() {
		System.out.println("Stopped");
	}
}

public class Composition {

	public static void main(String[] args) {
		Car obj = new Car();
		System.out.println(obj.model);
		obj.keyStart();

	}

}
