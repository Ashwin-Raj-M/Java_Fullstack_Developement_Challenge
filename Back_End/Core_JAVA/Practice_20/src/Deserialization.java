
import java.io.*;

public class Deserialization {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\AshwinRaj\\Documents\\GitHub\\Java_Fullstack_Developement_Challenge\\Back_End\\Core_JAVA\\Practice_20\\src\\Test\\Test.txt"));
			Test obj = (Test) in.readObject();
			System.out.println(obj.name);
			System.out.println(obj.age);
			System.out.println(obj.id);
			obj.show();
			in.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
