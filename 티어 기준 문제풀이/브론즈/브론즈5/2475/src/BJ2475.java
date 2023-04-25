import java.util.Scanner;

public class BJ2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int sum = 0;
        for(int i = 0; i<5; i++){
            num = sc.nextInt();
            sum += (num * num);
        }
        System.out.println(sum % 10);
    }
}
