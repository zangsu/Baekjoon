import java.util.*;

class BJ1463{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int[] DP = new int[X+1];
        DP[1] = 0;
        for(int i = 2; i<=X; i++){
            ArrayList<Integer> table = new ArrayList<Integer>();
            if(i%3 == 0)
                table.add(DP[i/3]);
            if(i%2 == 0)
                table.add(DP[i/2]);
            table.add(DP[i-1]);
            DP[i] = Collections.min(table)+1;
        }

        System.out.println(DP[X]);
    }
}