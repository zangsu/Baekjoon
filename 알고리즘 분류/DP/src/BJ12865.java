import java.util.*;

class item{
    int w;
    int p;

    item(int w, int p) {
        this.w = w;
        this.p = p;
    }
}
public class BJ12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int weight = sc.nextInt();

        item[] list = new item[num];
        int[][] DP = new int[num][];


        for (int i = 0; i < num; i++) {
            list[i] = new item(sc.nextInt(), sc.nextInt());
            DP[i] = new int[weight];

            for (int j = 0; j < weight; j++) {
                //DP table을 채우는 코드
            }
        }


    }
}
