import java.io.*;
import java.util.Scanner;

public class File_Reading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] datas = new String[2];
		FileReader obj =  new FileReader("C:\\Users\\ashwi\\Documents\\Eclipse Workspace\\Practice_19\\src\\Test_Files\\Test_file01.txt");
		Scanner sc = new Scanner(obj);
		int i = 0;
		while(sc.hasNextLine()) {
			datas[i] = sc.nextLine();
			i++;
		}
		
		for(String data : datas) {
			System.out.println(data);
		}
		obj.close();
	}

}
