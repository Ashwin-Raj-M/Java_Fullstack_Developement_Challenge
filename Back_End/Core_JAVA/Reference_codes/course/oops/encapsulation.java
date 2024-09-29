package oops;


class calculate{
    private int num1, num2; // --> these variables are encapsulated as the are private to the calculate class
    
    // These are setters and getters that enables us to access the private or encapsulated variables.
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add(){
        return num1 + num2;
    }
}
public class encapsulation{
    static int sub(int num1, int num2){
        return num1 - num2;
    }
    public static void main(String a[]){
        int num1 = 8, num2 = 9;
        calculate obj = new calculate();
        obj.setNum1(num1);
        obj.setNum2(num2);
        System.out.println(obj.getNum1());
        System.out.println(obj.getNum2());
        System.out.println(obj.add());
        System.out.println(sub(num1, num2));
    }
}