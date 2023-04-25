import java.util.Scanner;

public class BJ9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        long[] DP = new long[100];
        DP[0] = 1l;
        DP[1] = 1l;
        DP[2] = 1l;
        DP[3] = 2l;
        DP[4] = 2l;
        DP[5] = 3l;
        DP[6] = 4l;
        DP[7] = 5l;
        DP[8] = 7l;
        DP[9] = 9l;

        for(int i = 10; i<100; i++){
            DP[i] = DP[i - 1] + DP[i - 5];
        }

        for (int testNum = 0; testNum < test; testNum++) {
            int n = sc.nextInt();
            System.out.println(DP[n - 1]);
        }
    }
}
