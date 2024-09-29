
public class Main {

	public static void main(String[] args) {
		Personal per = new Personal();
		Address add = new Address();
		Student stu = new Student();
		College col = new College();
		
		System.out.println("Personal Details :");
		per.show();
		System.out.println("\nAddress Details :");
		add.show();
		System.out.println("\nStudent Details :");
		stu.show();
		System.out.println("\nCollege Details :");
		col.show();
	}
}
