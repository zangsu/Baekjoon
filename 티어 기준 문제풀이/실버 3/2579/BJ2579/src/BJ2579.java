import java.util.Collections;
import java.util.Scanner;

public class BJ2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stairNum = sc.nextInt();
        int[] stair = new int[stairNum];
        for(int i = 0; i<stairNum; i++)
            stair[i] = sc.nextInt();

        int[] scoreDP = new int[stairNum];
        int[] contStair = new int[stairNum];


        scoreDP[0] = stair[0];
        contStair[0] = 1;
        if(stairNum == 1){
            System.out.println(scoreDP[0]);
            return;
        }
        scoreDP[1] = stair[1] + scoreDP[0];
        contStair[1] = 2;
        if(stairNum == 2){
            System.out.println(scoreDP[1]);
            return;
        }
        if(stair[0] < stair[1]){
            scoreDP[2] = stair[1] + stair[2];
            contStair[2] = 2;
        }
        else{
            scoreDP[2] = stair[0] + stair[2];
            contStair[2] = 1;
        }
        for(int s = 3; s<stairNum; s++){

            int go;
            int jump = scoreDP[s-2];
            if(contStair[s-1] == 2)
                go = scoreDP[s-3] + stair[s-1];
            else
                go = scoreDP[s-1];

            if(go > jump){
                scoreDP[s] = stair[s] + go;
                contStair[s] = 2;
            }
            else{
                scoreDP[s] = stair[s] + jump;
                contStair[s] = 1;
            }
        }

        System.out.println(scoreDP[stairNum-1]);
    }
}
//10 30 35 55
// 1  2  2  1