
public class Local_Variable {
	
	Local_Variable(){// constructor
		char ch = 48;
		System.out.println("Local variable: " + ch);
	}
	
	void show(int loc) {//method
		int lv = loc;
		System.out.println("Local variable: " + lv);
		{//block
			int lv1 = '0';
			System.out.println("Local variable: " + lv1);
		}
//		System.out.println("Local variable: " + lv1); will not work
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Local_Variable loc = new Local_Variable();
		loc.show(100);
		 
	}

}
