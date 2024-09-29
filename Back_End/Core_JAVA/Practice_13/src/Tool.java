
public class Tool { // this class is called as java bean file since it is used for implementation of Encapsulation
	                // this class creates a template that encapsulates all the required data for the specific application
	
	private String name; // all the data members should be private for security reason
	private String mailID;
	private int age;
	private String city;
	private int accNo;
	private float ammount;
	
	// the data members should be accessed through getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public float getAmmount() {
		return ammount;
	}
	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}
	
	@Override
	public String toString() {
		return "Tool [name=" + name + ", mailID=" + mailID + ", age=" + age + ", city=" + city + ", accNo=" + accNo
				+ ", ammount=" + ammount + "]";
	}
	
}
