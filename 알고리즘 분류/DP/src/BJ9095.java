import java.util.*;
public class BJ9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> DP = new ArrayList<>();
        DP.add(1);
        DP.add(2);
        DP.add(4);
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (DP.size() > num) {
                System.out.println(DP.get(num-1));
            }
            else{
                while(DP.size()<num){
                    int next_step = DP.get(DP.size()-1) + DP.get(DP.size()-2) + DP.get(DP.size()-3);
                    DP.add(next_step);
                }
                System.out.println(DP.get(num-1));
            }
        }
    }
}
