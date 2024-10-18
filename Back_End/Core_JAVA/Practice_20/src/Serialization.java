import java.io.*;

class Test implements Serializable {
	private static final long serialVersionUID = 129348939L;
	String name;
	int age;
	static String race = "Asian"; // static members will not be serialized
	transient int id = 120; // transient keyword is used to prevent serialization of a member 
	public Test(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void show() {
		System.out.println(this.name); 
		System.out.println(this.age);
		System.out.println(race);
	}
}

public class Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Test obj = new Test("Ashwin",21);
			FileOutputStream fout = new FileOutputStream("C:\\Users\\AshwinRaj\\Documents\\GitHub\\Java_Fullstack_Developement_Challenge\\Back_End\\Core_JAVA\\Practice_20\\src\\Test\\Test.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(obj);
			out.flush();
			fout.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

}
