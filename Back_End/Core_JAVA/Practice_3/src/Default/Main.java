package Default;

public class Main {

	// unassigned
	byte b1;
	short s1;
	int i1;
	long l1;
	float f1;
	double d1;
	boolean bo1;
	char c1;
	
/*	initialized
	byte b1 = 10;
	short s1 = 10;
	int i1 = 10;
	long l1 = 10l;
	float f1 = 10f;
	double d1 = 10d;
	boolean bo1 = true;
	char c1 = 'A';
*/
	
	public static void main(String[] args) {
		Main def = new Main();
		
		System.out.println(def.b1);
		System.out.println(def.s1);
		System.out.println(def.i1);
		System.out.println(def.l1);
		System.out.println(def.f1);
		System.out.println(def.d1);
		System.out.println(def.bo1);
		System.out.println(def.c1);
	}

}
