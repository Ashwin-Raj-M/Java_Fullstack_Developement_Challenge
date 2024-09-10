
public class Encapsulation {
	public static void main(String arg[]) {
		
		Tool ashwin = new Tool(); // creates new object with ref-variable named "ashwin" and assigns the data members with default values
		
		// assigning values to the data members for this specific object
		ashwin.setName("Ashwin Raj M");
		ashwin.setMailID("rashwin344@gmail.com");
		ashwin.setAge(21);
		ashwin.setCity("Peramblalour");
		ashwin.setAccNo(12345);
		ashwin.setAmmount(100000);
		System.out.println(ashwin.toString());
		
		Tool aparnaa = new Tool(); // creates new object with ref-variable named "aparnaa" and assigns the data members with default values
		
		// assigning values to the data members for this specific object
		aparnaa.setName("Aparnaa M");
		aparnaa.setMailID("aparnaa344@gmail.com");
		aparnaa.setAge(2);
		aparnaa.setCity("Peramblaour");
		aparnaa.setAccNo(67890);
		aparnaa.setAmmount(200000);
		System.out.println(aparnaa.toString());
		
	}
}
