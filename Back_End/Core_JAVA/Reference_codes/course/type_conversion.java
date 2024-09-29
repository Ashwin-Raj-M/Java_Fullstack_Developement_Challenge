class type_conversion{
    @SuppressWarnings("unused") //--> ignore
    public static void main(String ar[]){
        int a = 256;
        // byte b = a; //--> shows error
        byte b = (byte)a; //is called explisit conversion or casting
        int  s = b; // works and is called implesit conversion or conversion
        System.out.println(b);
        float f = 5.6f;
        // int t = f; dont work
        int t = (int)f;
        System.out.println(t);
        byte r = 10;
        byte u = 30; // the product is 300 and out of byte range and hence the product is promoted to integer
        int result = r * u; // this is called type promotiom
        System.out.println(result);
    }
}