package Recquirements;

public class Dolmation extends Dog {
	public int spotNo = 23;
	public String name;
	public Dolmation(String food, String name) {
		super(food);
		this.name = name;
	}
	public String getDet() {
		return name + " " + spotNo;
	}
}
