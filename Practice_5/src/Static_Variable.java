/*
 * Static variables are also called as class variables 
 * They are created while the code starts to execute
 * There could only be one copy of the static variable and value of it is common for all objects
 */
public class Static_Variable{
	static String name = "Ashwin Raj M";
	static int age = 21;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Static_Variable obj = new Static_Variable();
		System.out.println(Static_Variable.name);// standard method of accessing static variable
		System.out.println(name);//Could be accessed like a local variable(compiler adds .[class_name] to it)
		System.out.println(obj.name);// Shows warning but still will work(compiler replaces .[object_name] with .[class_name])
	}

}
