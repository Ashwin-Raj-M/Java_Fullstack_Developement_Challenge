public class jagged_array{
    public static void main(String a[]){
        int arr[][] = new int[3][];
        arr[0] = new int[3];
        arr[1] = new int[2];
        arr[2] = new int[4];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = (int)(Math.random()*10); // random function from math class gives random double numbers less than 1(ie 0.12 and sililar numbers)
            }
        }
        for(int n[] : arr){
            for(int m : n){
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }
}