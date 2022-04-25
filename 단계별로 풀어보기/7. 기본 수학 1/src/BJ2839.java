import java.util.*;

public class BJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Sugar = sc.nextInt();
        int smallSugar = 0;
        while(Sugar > 0 && Sugar%5 != 0)
        {
            Sugar-= 3;
            smallSugar++;
        }
        if(Sugar % 5 == 0)
            System.out.printf("%d", smallSugar + (Sugar/5));
        else
            System.out.printf("-1\n");


    }
}
