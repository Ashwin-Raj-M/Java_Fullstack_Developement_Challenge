
interface Drawable{
	void draw();
}

class Rectange implements Drawable {
	public void draw() {
		System.out.println("Drawing Recatngle");
	}
}

class Circle implements Drawable {
	public void draw() {
		System.out.println("Drawing Circle");
	}
}

public class Interface_Hierarchy{
	public static void main(String arg[]) {
		Drawable obj = new Circle();
		obj.draw();
		Drawable obj1 = new Rectange();
		obj1.draw();
	}
}