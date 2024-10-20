enum Laptops{ 
	Mac(2000), Lenovo(1500), XPS(3000), Razer, Nitro(1200); // here the values are passed to the constructor
															// this allows private constructors, since objects
															// are created in the came class itself.
	
	int price;
	
	private Laptops(){} // default constructor to work with Razer
	
	private Laptops(int price){ // getting valuse from the line no. 2
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
}


public class More_On_Enum {
	
	public static void main(String[] args) {
		Laptops lap = Laptops.Mac; 
		System.out.println(lap + " : " + lap.price); // could also use getters and setters
		
		Laptops lap1 = Laptops.Razer; 
		lap1.setPrice(1800);
		
		for(Laptops lap2 : Laptops.values()) {
			System.out.println(lap2.ordinal() + 1 + ". " + lap2 + " : " + lap2.getPrice());
		}
	}
}
