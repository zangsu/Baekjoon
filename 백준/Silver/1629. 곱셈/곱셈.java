import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int mod = sc.nextInt();

        System.out.println(multiple(a, b, mod));
    }

    public static long multiple(long a, int b, int mod){
        if(b == 1)
            return a % mod;

        long result = multiple(a, b / 2, mod);
        if(b % 2 == 0){
            return (result * result)% mod;
        }
        else {
            return (((result * result) % mod) * a) % mod;
        }
    }
}