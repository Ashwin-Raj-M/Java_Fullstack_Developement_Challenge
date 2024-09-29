public class Instance_Variable {
	int Iv1;
	int Iv2 = 30;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instance_Variable ins = new Instance_Variable();//Constructor of the class Instance_Variable is called
														//and the variables are created in the heap and initialized with
														//default values if not manually initialized.
		System.out.println("Local variable: " + ins.Iv1);
		System.out.println("Local variable: " + ins.Iv2);
	}
}