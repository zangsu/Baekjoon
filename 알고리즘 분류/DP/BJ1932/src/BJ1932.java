import java.util.Arrays;
import java.util.Scanner;

public class BJ1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n][];
        for(int i = 0; i<n; i++){
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }
        int[] DP = new int[n];

        for (int i = 0; i < n; i++) {
            int[] newDP = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    newDP[j] = DP[0] + triangle[i][0];
                else if(j == i)
                    newDP[j] = DP[j - 1] + triangle[i][j];
                else{
                    int leftSum = DP[j - 1] + triangle[i][j];
                    int rightSum = DP[j] + triangle[i][j];
                    newDP[j] = leftSum > rightSum ? leftSum : rightSum;
                }
            }
            DP = newDP.clone();
        }

        int answer = DP[0];
        for (int i : DP) {
            if(i > answer)
                answer = i;
        }

        System.out.println(answer);
    }
}
