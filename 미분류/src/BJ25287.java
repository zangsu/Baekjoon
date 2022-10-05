import java.util.*;

public class BJ25287 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test = 0; test < T; test++) {
            int len = sc.nextInt();
            int N = len + 1;
            int inc = 1;
            int[] list = new int[len];
            for(int i = 0; i<len; i++)
                list[i] = sc.nextInt();

            for(int i = 0; i<len; i++){
                //각 원소마다 가능한 가장 작으면서 감소하지 않는 수로 바꾸기
                if(i == len -1) {
                    if (N - list[i] > list[i])
                        list[i] = N - list[i];
                }
                else if(N - list[i] < list[i]){
                    if(i == 0)
                        list[i] = N - list[i];
                    else{
                        if(N-list[i] >= list[i-1])
                            list[i] = N-list[i];
                    }
                }

                //바꾼 후에도 이전 원소보다 작다면 출력
                if(i != 0 && list[i-1] > list[i] ){
                    inc = 0;
                    break;
                }
            }

            if(inc == 0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }//test 블럭
    }
}
