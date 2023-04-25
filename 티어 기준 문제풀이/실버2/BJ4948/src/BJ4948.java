import java.util.Scanner;

public class BJ4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while(true){
            int cnt = 0;
            n = sc.nextInt();
            if(n == 0)
                break;
            for(int i = n+1; i<= 2*n; i++){
                if(isPrime(i))
                    cnt++;
            }
            System.out.println(cnt);

        }
    }

    private static boolean isPrime(int num) {

        if(num % 2 == 0) {
            if(num == 2)
                return true;
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
