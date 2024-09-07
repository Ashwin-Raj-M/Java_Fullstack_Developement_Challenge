class calculate{
    int num1, num2;
    public calculate(int n1, int n2){
        num1 = n1;
        num2 = n2;
    }
    public int add(){
        return num1 + num2;
    }
}
public class oops{
    static int sub(int num1, int num2){
        return num1 - num2;
    }
    public static void main(String a[]){
        int num1 = 8, num2 = 9;
        calculate obj = new calculate(num1, num2);
        System.out.println(obj.add());
        System.out.println(sub(num1, num2));
    }
}