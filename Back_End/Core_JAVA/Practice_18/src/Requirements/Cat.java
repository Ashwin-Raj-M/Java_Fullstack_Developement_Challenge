package Requirements;

public class Cat extends Animal{
	public String food = "cat food";
	public int age = 4;
	public void sound() {
		System.out.println("Meow");
	}
	public void color() {
		System.out.println("white");
	}
	public Cat(){}
	public Cat(String food) {
		super(food);
	}
}