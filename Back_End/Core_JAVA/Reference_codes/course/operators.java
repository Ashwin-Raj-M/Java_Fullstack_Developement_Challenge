class operators{
    public static void main(String ar[]){
        int num1 = 7;
        int num2 = 5;

        int result1 = num1 + num2;
        int result2 = num1 - num2;
        int result3 = num1 * num2;
        int result4 = num1 / num2;
        int result5 = num1 % num2;

        System.out.println(result1); 
        System.out.println(result2); 
        System.out.println(result3); 
        System.out.println(result4); 
        System.out.println(result5); 
        System.out.println(num1 = num2 + 2);
        // is similar to 
        System.out.println(num1 += 2);
        System.out.println(num1 += 1); //this concept is same for all the operators like +=, -=, *=, /=
        // is similar to
        System.out.println(num1++); //not incremented not but in the next step (post increment)
        System.out.println(num1); 
        System.out.println(++num1); //incremented and printed (pre increment) 
        // the difference is in the fetching. Post inc --> fetched first then incremented, pre inc --> first increment and fetches value 

        boolean bool = num1 < 8 & num2 > 2;// is called logical operation (takes longer to compile)
        boolean bool1 = num1 < 8 && num2 > 2;// is called short circuit logical (takes less time to compile)
        System.out.println(bool); 
        System.out.println(bool1); 
    }
}