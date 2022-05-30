import java.util.*;

public class BJ1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num > 0) {
            int N = sc.nextInt();
            if(N >= 2){
                int[][] DP = new int[N + 1][2];
                DP[0][0] = 1;
                DP[1][1] = 1;
                int i = 2;
                while (i < N + 1) {
                    DP[i][0] = DP[i - 1][0] + DP[i - 2][0];
                    DP[i][1] = DP[i - 1][1] + DP[i - 2][1];
                    i++;
                }
                System.out.println(DP[N][0] + " " + DP[N][1]);
            }
           else if(N == 1)
                System.out.println("0 1");
           else
                System.out.println("1 0");

            num--;
        }
    }
}
