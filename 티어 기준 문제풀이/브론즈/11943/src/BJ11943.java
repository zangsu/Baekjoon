import java.util.Scanner;

public class BJ11943 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int apple1 = sc.nextInt();
        int orange1 = sc.nextInt();
        int apple2 = sc.nextInt();
        int orange2 = sc.nextInt();

        int sum1 = apple1 + orange2;
        int sum2 = apple2 + orange1;
        if(sum1 < sum2)
            System.out.println(sum1);
        else
            System.out.println(sum2);
    }
}
