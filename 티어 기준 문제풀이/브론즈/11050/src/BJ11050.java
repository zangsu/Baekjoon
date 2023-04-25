import java.util.Scanner;

public class BJ11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] DP = new int[n];
        for(int i = 0; i<n; i++){
            if(i == 0){
                DP[i] = 1;
            }
            else
                DP[i] = DP[i-1] * (i+1);
        }
        if(k == 0 || k == n)
            System.out.println(1);
        else
            System.out.println(DP[n-1] / (DP[k-1] * DP[n-k-1]) );
    }
}
