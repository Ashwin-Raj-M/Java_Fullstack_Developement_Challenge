import Recquirements.*;

public class Hierarchy_Inheritance {

	public static void main(String[] args) {

		Dog obj = new Dog("pedigiri");
		obj.sound();
		System.out.println(obj.food);
		
		Cat obj1 = new Cat("milk");
		obj1.sound();
		System.out.println(obj1.food);
	}

}

