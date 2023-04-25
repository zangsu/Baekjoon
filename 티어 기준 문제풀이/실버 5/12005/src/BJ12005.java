import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ12005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int max = 0;
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            list.add(sc.nextInt());
        }
        //Collections.sort(list);
        for(int i = 1; i<n; i++){
            if(list.get(i) - list.get(i-1) < k && list.get(i-1) - list.get(i) < k ) {
                count++;
                if(max < count)
                    max = count;
            }
            else
                count = 1;
        }
        System.out.println(max);

    }
}
