import java.util.Scanner;

public class BJ5607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int game = sc.nextInt();
        int sumA = 0;
        int sumB = 0;
        for(int i = 0;i<game; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a < b)
                sumB += (a + b);
            else if(a> b)
                sumA += (a + b);
            else{
                sumA += a;
                sumB += b;
            }
        }
        System.out.println(sumA + " " + sumB);
    }
}
