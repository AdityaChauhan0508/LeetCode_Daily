import java.util.ArrayList;
import java.util.Scanner;

public class prac2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] str = s.split(",");

        ArrayList<Integer> arr = new ArrayList<>();

        for(String token : str) {
            int num = Integer.parseInt(token);
            arr.add(num);
        }

        int x = 0;

        for(int i : arr) {
            x = x ^ i;
        }
        System.out.println(x);

    }
    
}
