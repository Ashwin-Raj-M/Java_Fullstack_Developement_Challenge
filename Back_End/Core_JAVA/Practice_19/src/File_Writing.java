import java.io.FileWriter;
import java.io.IOException;

public class File_Writing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter obj1 = new FileWriter("C:\\Users\\ashwi\\Documents\\Eclipse Workspace\\Practice_19\\src\\Test_Files\\Test_file01.txt");
		obj1.write("This is my first file. And I would like to make it great.\nThankyou.");
		obj1.close();
		System.out.println("Writing is Successful");
	}
}
