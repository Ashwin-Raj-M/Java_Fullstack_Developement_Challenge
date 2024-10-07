package Requirements;

public class Animal{
	public String food = "animal food";
	public void sound() {
		System.out.println("sound");
	}
	public Animal(){}
	public Animal(String food) {
		this.food = food;
	}
}