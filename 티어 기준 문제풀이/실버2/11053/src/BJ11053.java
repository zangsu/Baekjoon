import java.util.*;

public class BJ11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        int ans = Onlogn(array);
        System.out.println(ans);
    }
    public static int On2(int[] array){
        int[] DP = new int[array.length];
        DP[0] = 1;
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            int arrayMax = 0;
            int indexMax = 0;
            int dpMax = 0;
            for(int j = 0; j<i; j++){
                if(array[j] < num && DP[j] > dpMax){
                    arrayMax = array[j];
                    indexMax = j;
                    dpMax = DP[j];
                }
            }
            DP[i] = dpMax + 1;
            if(max < DP[i])
                max = DP[i];

        }
/*
        System.out.println();
        for(int i : array)
            System.out.printf("%2d ", i);
        System.out.println();
        for(int i : DP)
            System.out.printf("%2d ", i);*/

        return max;
    }
    public static int Onlogn(int[] array){
        int[] subDP = new int[array.length];
        //i-1 길이의 부분수열 중 가장 작은 끝나는 값
        int subDPLen = 1;

        subDP[0] = array[0];
        for(int i = 1; i<array.length; i++){
            int j = 0;
            for(; j<subDPLen; j++){
                if(array[i] <= subDP[j])
                    break;
            }
            if(j == subDPLen)
                subDP[subDPLen++] = array[i];
            else{
                subDP[j] = array[i];
            }
        }

        return subDPLen;
    }
}
