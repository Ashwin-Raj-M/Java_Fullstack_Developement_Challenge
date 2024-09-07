class A{
    public void show1(){
        System.out.println("A");
    }
}
class B extends A{
    public void show2(){
        System.out.println("B");
    }
}
public class up_down_casting {
    public static void main(String[] args) {
        A obj = (A) new B();//Downcasting, also works like this A obj = new B();
        obj.show1();
        // obj.show2();// dosnt work because the A datatype desn't know about class B
        B obj1 = (B) obj;// Upcasting
        obj1.show2();
        obj.show1();//works because the B datatype knows about class A since it extends A
    }
}
