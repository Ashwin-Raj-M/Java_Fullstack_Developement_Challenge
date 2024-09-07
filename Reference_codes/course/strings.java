public class strings{
    public static void main(String a[]){
        StringBuffer name1 = new StringBuffer("Ashwin raj"); // --> this is mutable string declarstion 
        String name = "Ashwin"; // --> this is immutable string declarstion since string declaration is immutable in default
        System.out.println(name1.capacity());
        System.out.println(name1.length());
        System.out.println(name);
        name += " Raj";
        System.out.println(name);
        String s1 = "ashwin"; 
        String s2 = "ashwin";
        if(s1 == s2) System.out.println("True");
    }
}