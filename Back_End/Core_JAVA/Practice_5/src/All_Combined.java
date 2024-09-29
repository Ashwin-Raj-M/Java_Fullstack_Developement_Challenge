
import java.util.Scanner;

public class All_Combined {
	static String college = "KCT";
	String studentName;
	int roll;
	char grade;
	
	All_Combined(String studentName, int roll, char grade){
		this.studentName = studentName;
		this.roll = roll;
		this.grade = grade;
	}
	
	public void show() {
		System.out.println(college + studentName + roll + grade);
	}
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in)) {
			String name = scanner.nextLine();
			int roll = scanner.nextInt();
			char grade = scanner.next().charAt(0);
			
			All_Combined obj = new All_Combined(name, roll, grade);
			
			obj.show();
		}
	}

}
