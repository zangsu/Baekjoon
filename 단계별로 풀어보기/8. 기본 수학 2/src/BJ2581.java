import java.util.*;

public class BJ2581 {
    static int isPrime(int number){
        if(number == 1)
            return 0;
        else if(number == 2)
            return 1;
        else if(number %2 == 0)
            return 0;
        else{
            int i = 2;
            while(i <= (number/2)+1 ){
                if(number%i == 0)
                    break;
                i++;
            }
            if(i >= (number/2) +1)
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int min = 0, sum = 0;
        for(int number = M; number<=N; number++){
            if(isPrime(number) == 1)
            {
                if(min == 0)
                    min = number;
                sum += number;
            }
        }
        if(sum == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
