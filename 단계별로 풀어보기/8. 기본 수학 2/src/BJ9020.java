import java.util.*;
public class BJ9020 {
    static int isPrime(int number) {
        if(number == 1)
            return 0;
        else if(number == 2)
            return 1;
        else if(number%2 == 0)
            return 0;
        else{
            for(int i = 3; i<(number/2)+1; i++){
                if(number%i == 0)
                    return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i<N ;i++){
            int number = sc.nextInt();
            int div = number/2;
            while(true){
                if(isPrime(div) == 1 && isPrime(number-div) == 1)
                    break;
                div--;
            }
            System.out.printf("%d %d\n", div, number - div);
        }
    }
}
