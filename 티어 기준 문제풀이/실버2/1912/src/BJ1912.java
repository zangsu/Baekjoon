import java.util.Scanner;

public class BJ1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int max = -1001;
        int min = 1000;
        int[] array = new int[len];
        int[] DP = new int[len];
        for(int i = 0; i<len; i++){
            array[i] = sc.nextInt();
            if(i == 0) {
                DP[i] = array[i];
                if(array[i] < 0)
                    min = array[i];
                else
                    min = 0;
                max = array[i];
                continue;
            }
            else
                DP[i] = DP[i-1] + array[i];
            if(DP[i] - min > max)
                max = DP[i] - min;
            if(DP[i] < min) {
                min = DP[i];
            }


        }
        System.out.println(max);

    }
}
