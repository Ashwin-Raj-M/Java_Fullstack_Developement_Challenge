//package AK_Sir;
//
//// Java code to show structures and
//// members of Java Program
//public class Main {
//
//    // Static member
//    static int staticNum = 0;
//
//    // Instance member
//    int instanceNum;
//
//    /* below constructor increments the static
//    number and initialize instance number */
//    // Constructor method
//    public Main(int i)
//    {
//        instanceNum = i;
//        staticNum++;
//    }
//
//    /* The show method display the value in the staticNum
//     * and instanceNum */
//    // instance method
//    public void show()
//    {
//        System.out.println(
//            "Value of Static Number is:" + staticNum
//            + "\nValue of Instance number is:"
//            + instanceNum);
//    }
//
//    // To find cube
//    // Static method
//    public static int cube()
//    {
//        return staticNum * staticNum * staticNum;
//    }
//
//    // Driver code
//    public static void main(String args[])
//    {
//        Main gvp1 = new Main(2);
//        System.out.println(
//            "Value after gvp1 object creation: ");
//        gvp1.show();
//
//        Main gvp2 = new Main(4);
//        System.out.println(
//            "Value after gvp2 object creation: ");
//        gvp2.show();
//
//        // static method can be accessed by class name
//        int cub = Main.cube();
//        System.out.println("Cube of the Static number is: "+ cub);
//    }
//}