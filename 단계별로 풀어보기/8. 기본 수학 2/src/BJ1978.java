import java.util.*;
public class BJ1978 {
    static int IsPrime(int number){
        if(number == 1)
            return 0;
        else if(number == 2)
            return 1;
        else if(number%2 == 0)
            return 0;
        else{
            int i = 3;
            while(i <= (number/2)+1){
                if(number%i == 0)
                    break;
                i++;
            }
            if(i >= number/2 + 1)
                return 1;
            else
                return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Prime  = 0;
        for(int i = 0; i<n; i++){
            int number = sc.nextInt();
            if(IsPrime(number) == 1)
                Prime++;
        }
        System.out.println(Prime);

    }

}
