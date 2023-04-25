import java.util.Comparator;
import java.util.Scanner;

public class BJ7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Man[] list = new Man[N];
        int[] rank = new int[N];

        for(int i = 0; i<N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[i] = new Man(a, b);
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(i == j)
                    rank[i]++;
                else{
                    if(list[i].h < list[j].h && list[i].w < list[j].w)
                        rank[i]++;
                }
            }
        }

        for (int i : rank) {
            System.out.print(i + " ");
        }

    }
    static class Man{
        int w;
        int h;
        public Man(int a, int b){
            this.w = a;
            this.h = b;
        }

    }
}
