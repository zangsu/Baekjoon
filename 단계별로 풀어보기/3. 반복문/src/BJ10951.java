import java.util.*;
public class BJ10951{
    public static void main(String[] args){
        int a, b;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            a = sc.nextInt();
            if(a == ' ')
                break;
            b = sc.nextInt();
            System.out.println(a+b);
        }

    }
}