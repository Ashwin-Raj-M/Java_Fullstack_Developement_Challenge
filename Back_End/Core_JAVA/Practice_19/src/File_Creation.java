/**
 * The File class from the java.io package, allows us to work with files.
 * To use the File class, create an object of the class, and specify the filename or directory name
 *
 * !! Run these codes at your own risk !!
 * 
 * !! Wrong file path may lead to deletion or damage to other files !!
 * 
 * !! Do select a safe and empty memory location to execute this code !!
 * 
 * @author ashwi
 *
 */

import java.io.File;
import java.io.IOException;
//import java.io.IOexception;

public class File_Creation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File obj1= new File("C:\\Users\\ashwi\\Documents\\Eclipse Workspace\\Practice_19\\src\\Test_Files\\Test_file01.txt");
			File obj2 = new File("C:\\Users\\ashwi\\Documents\\Eclipse Workspace\\Practice_19\\src\\Test_Files\\Test_file02.pdf");
			File obj3 = new File("C:\\Users\\ashwi\\Documents\\Eclipse Workspace\\Practice_19\\src\\Test_Files\\Test_file03.docx");
			File obj4 = new File("C:\\Users\\ashwi\\Documents\\Eclipse Workspace\\Practice_19\\src\\Test_Files\\Test_file04.xls");
			
			if(obj1.createNewFile()) {
				System.out.println("File 1 created successfully");
			}
			else{
				System.out.println("File 1 already exists");
			}
			if(obj2.createNewFile()) {
				System.out.println("File 2 created successfully");
			}
			else{
				System.out.println("File 2 already exists");
			}
			if(obj3.createNewFile()) {
				System.out.println("File 3 created successfully");
			}
			else{
				System.out.println("File 3 already exists");
			}
			if(obj4.createNewFile()) {
				System.out.println("File 4 created successfully");
			}
			else{
				System.out.println("File 4 already exists");
			}
		}
		
		catch(IOException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}
}
