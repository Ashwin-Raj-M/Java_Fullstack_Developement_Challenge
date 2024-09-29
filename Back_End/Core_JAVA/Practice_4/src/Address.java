
public class Address {
	String doorNo = "255 DA / 13";
	String street= "Vetri Nagar";
	String area = "VM Road";
	String district = "Perambalur";
	int pin = 621212;
	
	public void show() { 
		System.out.println("Address : " + doorNo + ", " + street + ", " + area 
				+ ", " + "\n" + district + ", " + pin + ".");
	}
}
