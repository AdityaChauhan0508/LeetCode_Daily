import java.util.Scanner;

public class prac1{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        int sum = 0;

        while(n > 0) {
            sum += n % 10;
            n = n / 10;
        }

        sum = sum * r;

        while(sum > 9) {
            int ans = 0;

            while(sum > 0) {
                ans += sum % 10;
                sum /= 10;
            }
            sum = ans;
        }
        System.out.print(sum);
    }    
}