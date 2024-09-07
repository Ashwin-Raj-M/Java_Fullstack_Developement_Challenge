/**
 * like if else switch statements are not executed line by line, hence the oder of the cases dose not matter
 * 
 * @author ashwi
 *
 */
public class Switch_statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3;
		
		switch(a) {
		
		default:
			System.out.println("default");// dosen't matter there the default is given, if not given in last break should be added
			break;
			
		case 1:
			System.out.println("1");
			break;
			
		case 2:
			System.out.println("2");
			break;

		case 3:
			System.out.println("3");
			break;

		case 4:
			System.out.println("4");
			break;

		}
		
		char b = '0';
		
		switch(b) { // also works based on the ASCI values
		
		default:
			System.out.println("default");
			break;
			
		case 48:
			System.out.println("0");
			break;
			
		case 49:
			System.out.println("1");
			break;

		case 50:
			System.out.println("2");
			break;

		case 51:
			System.out.println("3");
			break;

		}

	}
		
}
