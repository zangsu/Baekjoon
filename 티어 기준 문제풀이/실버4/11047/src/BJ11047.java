import java.util.Scanner;

public class BJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        int K = sc.nextInt();
        int[] coin = new int[N];
        for(int i = 0; i<N; i++)
            coin[i] = sc.nextInt();
        for(int i = N-1; i>=0; i--){
            if(K == 0)
                break;
            cnt += K / coin[i];
            K = K % coin[i];
        }
        System.out.println(cnt);

    }
}
