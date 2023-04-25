import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cardNum = sc.nextInt();
        int answer = 0;
        int num = sc.nextInt();
        int minDiff = -1;
       int[] card = new int[cardNum];
        for(int i = 0; i<cardNum; i++)
            card[i] = sc.nextInt();

        for(int i = 0; i<cardNum-2; i++){
            for(int j = i+1; j<cardNum-1; j++){
                for(int k = j+1; k<cardNum; k++){
                    int sum = card[i] + card[j] + card[k];
                    int diff = num - sum;
                    if(diff < 0)
                        continue;
                    if(minDiff == -1 || minDiff > diff) {
                        minDiff = diff;
                        answer = sum;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
