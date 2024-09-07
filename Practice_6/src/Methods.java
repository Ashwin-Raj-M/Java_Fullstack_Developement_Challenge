
class TempMethod{
	public void sum() {// without return and without parameters
		System.out.println(12 + 15); 
	}
	
	public void sub(int a, int b) {// without return and with parameters
		System.out.println(a - b);
	}
	
	public int mul() {// with return and without parameters
		return 12 * 15;
	}
	
	public float div(int a, int b) {// with return and with parameters
		return b / a;
	}
	
	public static int mod(int a, int b) {// static method declaration
		return b % a;
	}
}

public class Methods {

	public static void main(String[] args) {
		int a = 12, b = 15;
		TempMethod obj = new TempMethod();
		obj.sum();
		obj.sub(a, b);
		int pro = obj.mul();
		System.out.println(pro);
		float que = obj.div(a, b);
		System.out.println(que);
		int modu = TempMethod.mod(a ,b);// calling static method, hence no object is required
		System.out.println(modu);

	}

}
