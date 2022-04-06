import java.util.*;
public class BJ2438{
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 1; i<=n; i++)
        {
            for(int j = i; j>=1; j--)
                System.out.print("*");
            System.out.println("");
        }
    }
}