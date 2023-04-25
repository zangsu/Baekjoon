import java.util.Scanner;

public class BJ4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if( a == 0 &&  b == 0 && c == 0)
                break;
            int big = 0;
            int small1 = 0;
            int small2 = 0;
            if (a > b && a > c) {
                big = a;
                small1 = b;
                small2 = c;
            } else if (b > a && b > c) {
                big = b;
                small2 = a;
                small1 = c;
            } else {
                big = c;
                small1 = a;
                small2 = b;
            }

            if (big * big == (small1 * small1) + (small2 * small2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}
