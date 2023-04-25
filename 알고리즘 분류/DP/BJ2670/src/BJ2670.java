import java.util.Scanner;

public class BJ2670 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] numbers = new double[n];
        for(int i = 0; i<n; i++) {
            numbers[i] = sc.nextDouble();
        }

        double[] DP = new double[n];
        for(int i = 0; i<n; i++)
            DP[i] = numbers[i];

        double max = DP[0];
        double[] newDP = new double[n];

        for(int i = 1; i<n; i++){ //연속으로 곱하는 숫자

            /*for(int j = i; j<n; j++){
                newDP[j] = (DP[j-1] * 10) * (numbers[j] * 10) / 100;
                if(max < newDP[j])
                    max = newDP[j];
            }

            for(int j = 0; j<n; j++) {
                DP[j] = newDP[j];
            }*/
            double mult = DP[i - 1] * numbers[i];
            if(mult > numbers[i])
                DP[i] = mult;
        }

        for(int i = 0; i<n; i++)
            if(max < DP[i])
                max = DP[i];

        /*System.out.println(max);*/
        max = Math.round(max*1000)/1000.0;
        System.out.printf("%.3f",max);
    }
}
/*
* 방법 1 : n번째 숫자까지의 곱으로 구할 수 있는 최대값
*
* DP가 저장하고 있는 값 :
*   n번째 :
* */

/*
방법 2
    1. 0번쨰 부터 n번쨰 까지의 수를 다 곱한 수를 DP가 저장
    2. DP 안에서 각 값들을 나누어 보면서 확인
        -> n번째 DP에서 k번쨰 DP를 나누면 k+1부터 n번째 까지의 곱
 */


//128MB = 2^7 * 10^6 ?? 8 * 2 * 10^3