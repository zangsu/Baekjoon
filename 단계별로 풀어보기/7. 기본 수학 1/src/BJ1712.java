import java.util.*;
public class BJ1712{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();
        if(b >= c)
            System.out.println(-1);
        else
        {
            long ben = c - b;
            if(a % ben != 0){
                if(a/ben != 0)
                    System.out.println(a/ben);
                else
                    System.out.println(1);
            }
            else
                System.out.println((a/ben) + 1);
        }
    }
}