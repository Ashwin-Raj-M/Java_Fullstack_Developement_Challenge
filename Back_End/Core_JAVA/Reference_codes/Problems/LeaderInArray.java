import java.util.*;

public class LeaderInArray {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            outer:
            for (int i = 0; i < n; i++) {
                if(i == n - 1) {
                    System.out.print(arr[i]);
                    continue;
                }
                for(int j = i + 1; j < n; j++) {
                    if(arr[i] < arr[j]) {
                        continue outer;
                    }
                }
                System.out.print(arr[i] + " ");
            }
        }
    }
}
