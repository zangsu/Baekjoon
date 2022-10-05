import java.util.*;

public class BJ25194 {
    //문제 해결방법 : 각 입력별로 mod7에 해당하는 수의 개수를 센다.
    //이후 해당 mod개수들의 적당한 합 mod 7이 4가 만들어 진다면 성공!
    //dfs 방식으로 브루트포스 해보기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int solve = 0;

        int[] mod = new int[7];
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            mod[num%7]++;
        }

        if(mod[4] != 0)
            solve = 1;
        else{

        }
    }
}
