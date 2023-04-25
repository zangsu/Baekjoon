import java.util.Scanner;

public class BJ14624 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0)
            System.out.print("I LOVE CBNU");
        else{
            for(int i = 0; i<n; i++)
                System.out.print("*");
            System.out.println();
            int lim = n / 2;
            for(int i = 0; i<= lim; i++){
                for(int j = 0; j<=lim+i; j++){
                    if(j-i == lim || i + j == lim)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                if(i != lim)
                    System.out.println();
            }
        }
    }
}