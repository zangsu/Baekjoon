import java.util.HashSet;
import java.util.Scanner;

public class BJ1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int num = sc.nextInt();
        for(int i = 0; i<num; i++){
            int n = sc.nextInt();
            set.add(n);
        }
        num = sc.nextInt();
        for(int i = 0; i<num; i++){
            int n = sc.nextInt();

            if(set.contains(n))
                System.out.println(1);
            else
                System.out.println(0);

        }
    }
}
