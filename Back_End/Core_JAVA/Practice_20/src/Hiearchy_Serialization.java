import java.io.*;

class TestParent implements Serializable{
	int num;
	public TestParent() {
	}
}

class Address implements Serializable { 
	int doorNum;
	String street;
	String area;
	String district;
	public void show() {
		System.out.println(this.doorNum);
		System.out.println(this.street);
		System.out.println(this.area);
		System.out.println(this.district);
	}
	public Address(int doorNum, String street, String area, String district) {
		this.doorNum = doorNum;
		this.street = street;
		this.area = area;
		this.district = district;
	}
}

class PersonalDetails implements Serializable { // Both the HAS class and A class should implement Serializable to be serialized . ie:- Has A Relationship)Personal Details has Address
	private static final long serialVersionUID = 129348937L;
	String name;
	int age;
	Address par;
	static String race = "Asian"; // static members will not be serialized
	public PersonalDetails(String name, int age, int num, int doorNum, String street, String area, String district) {
		this.name = name;
		this.age = age;
		this.par = new Address(doorNum, street, area, district);
	}
	public void show() {
		System.out.println(this.name); 
		System.out.println(this.age);
		par.show();
			
	}
}

class TestChild extends TestParent { // child of a class that implements Serializable interface, is Serializable too. ie:- IS A Relationship)
	private static final long serialVersionUID = 129348934L;
	String name;
	int age;
	static String race = "Asian"; // static members will not be serialized
	transient int id = 120; // transient keyword is used to prevent serialization of a member 
	public TestChild(String name, int age, int num) {
		this.name = name;
		this.age = age;
		this.num = num;
	}
	public void show() {
		System.out.println(this.name); 
		System.out.println(this.age);
		System.out.println(this.id);
		System.out.println(race);
	}
}

public class Hiearchy_Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TestChild obj = new TestChild("Ashwin", 21, 5);
			File f = new File("C:\\Users\\AshwinRaj\\Documents\\GitHub\\Java_Fullstack_Developement_Challenge\\Back_End\\Core_JAVA\\Practice_20\\src\\Test\\Test1.txt");
			FileOutputStream fout = new FileOutputStream("C:\\Users\\AshwinRaj\\Documents\\GitHub\\Java_Fullstack_Developement_Challenge\\Back_End\\Core_JAVA\\Practice_20\\src\\Test\\Test1.txt");
			if(f.createNewFile()) {
				System.out.println("File Created");
			}
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(obj);
			out.flush();
			fout.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		try {
			PersonalDetails obj = new PersonalDetails("Ashwin", 21, 5, 255, "Arunachal Nagar", "VM Road", "Peramblaur");
			File f = new File("C:\\Users\\AshwinRaj\\Documents\\GitHub\\Java_Fullstack_Developement_Challenge\\Back_End\\Core_JAVA\\Practice_20\\src\\Test\\Test2.txt");
			FileOutputStream fout = new FileOutputStream("C:\\Users\\AshwinRaj\\Documents\\GitHub\\Java_Fullstack_Developement_Challenge\\Back_End\\Core_JAVA\\Practice_20\\src\\Test\\Test2.txt");
			if(f.createNewFile()) {
				System.out.println("File Created");
			}
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(obj);
			out.flush();
			fout.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\AshwinRaj\\Documents\\GitHub\\Java_Fullstack_Developement_Challenge\\Back_End\\Core_JAVA\\Practice_20\\src\\Test\\Test1.txt"));
			TestChild obj = (TestChild) in.readObject();
//			System.out.println(obj.name);
//			System.out.println(obj.age);
//			System.out.println(obj.id);
			obj.show();
			in.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\AshwinRaj\\Documents\\GitHub\\Java_Fullstack_Developement_Challenge\\Back_End\\Core_JAVA\\Practice_20\\src\\Test\\Test2.txt"));
			PersonalDetails obj = (PersonalDetails) in.readObject();
//			System.out.println(obj.name);
//			System.out.println(obj.age);
			obj.show();
			in.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}