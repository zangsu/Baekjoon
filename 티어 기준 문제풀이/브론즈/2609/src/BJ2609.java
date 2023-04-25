import java.util.Scanner;

public class BJ2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int big = sc.nextInt();
        int small = sc.nextInt();
        if(big < small){
            int temp = big;
            big = small;
            small = temp;
        }
        int a = big;
        int b = small;
        while (a % b != 0) {
            int temp = a%b;
            a = b;
            b= temp;
        }
        System.out.println(b);
        int GCD = 0;
        for(int i = 1;; i++){
            GCD = b * i;
            if(GCD % big == 0 && GCD % small == 0)
                break;
        }
        System.out.println(GCD);
    }
}
