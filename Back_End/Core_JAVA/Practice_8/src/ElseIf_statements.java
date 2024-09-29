/**
 * always skips all the else if statements that is bellow the true ststemint
 * 
 * @author ashwi
 *
 */
public class ElseIf_statements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 15;
		int b = 20;
		
		if(a == b) {
			System.out.println("equal");
		}else if(a <= b) {
			System.out.println("less than");
		}else if(a >= b) {
			System.out.println("greater than");
		}else {
			System.out.println("not equal");
		}
	}

}
