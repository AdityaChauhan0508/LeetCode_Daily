import java.util.Scanner;

public class prac4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int buy = arr[0];
        int p = 0;

        for(int i=0; i<arr.length; i++) {
            int pr =  arr[i] - buy;
            
            buy = Math.min(buy, arr[i]);
            p = Math.max(p, pr);
        }
        System.err.println(p);
    }
    
}
