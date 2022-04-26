import java.util.*;
public class BJ11653 {
    static int isPrime(int num){
        if(num == 1)
            return 0;
        else if(num == 2)
            return 1;
        else if(num %2 == 0)
            return 0;
        else{
            for(int i = 3; i<(num/2)+1; i++){
                if(num % i == 0)
                    return 0;
            }
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int div = 2;
        if(N!= 1){
            while(isPrime(N) != 1){
                if(N % div == 0)
                {
                    System.out.println(div);
                    N/=div;
                }
                else
                {
                    while(isPrime(++div) != 1)
                        ;
                }
            }
            System.out.println(N);
        }

    }
}
