import java.io.*;

public class File_Deleting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File obj = new File("C:\\Users\\ashwi\\Documents\\Eclipse Workspace\\Practice_19\\src\\Test_Files\\Test_file01.txt");
		if(obj.delete()) {
			System.out.println("File deleted Successfully");
		}else {
			System.out.println("Deletion Failed");
		}
	}

}
