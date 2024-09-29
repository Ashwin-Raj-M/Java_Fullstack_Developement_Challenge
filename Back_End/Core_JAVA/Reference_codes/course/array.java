class car{
    int price;
    String model;
    int milage;
}
public class array{
    public static void main(String a[]){

        car obj1 = new car();
        obj1.price = 10000;
        obj1.model = "xuv";
        obj1.milage = 70;

        car obj2 = new car();
        obj2.price = 20000;
        obj2.model = "muv";
        obj2.milage = 60;

        car obj3 = new car();
        obj3.price = 30000;
        obj3.model = "suv";
        obj3.milage = 90;

        car arr[] = new car[3];
        arr[0] = obj1;
        arr[1] = obj2;
        arr[2] = obj3;

        for(car array : arr){
            System.out.println(array.price);
            System.out.println(array.model);
            System.out.println(array.milage);
        }

    }
}