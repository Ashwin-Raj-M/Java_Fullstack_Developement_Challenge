class mobile{
    String brand;
    static String name; // --> ststic variable declaration
    int price;
    static{ // --> static block to initialize static variables since they should no be initialized muliple times
        name = "phone"; // --> static variable initialization
        System.out.println("static called");
    }
    public mobile(){ // --> constructors to initialize instance variable, since they have to be initialized seperately for each object
        brand = " ";
        price = 0;
        System.out.println("constructor called called");
    }
    public void show(){
        System.out.println(brand + " " + name + " " + price);
    }
    public static void show1(mobile obj){
        System.out.println(obj.brand + " " + name + " " + obj.price); // --> non static variable are not allowed to be used hence called trough object name.
    }
}
public class statickey{
    public static void main(String a[]){
        mobile obj1 = new mobile();
        obj1.brand = "apple";
        obj1.price = 12000;

        mobile obj2 = new mobile();
        obj2.brand = "samsung";
        obj2.price = 1200;

        //to access static variable
        mobile.name = "smart phone";

        // calling show method (non static)
        obj1.show();
        obj2.show();

        // calling show1 method (static)
        mobile.show1(obj1);
        mobile.show1(obj2);
    }
}