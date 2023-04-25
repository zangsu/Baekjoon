import java.util.Scanner;

public class BJ1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int u = sc.nextInt();

        for(int i = l; i<=u; i++){
            if(i == 1)
                continue;
            boolean isPrime = true;
            for(int j = 2; j<=Math.sqrt(i); j++){
                if(i%j == 0){
                    isPrime = false;
                    //System.out.println(j + " " + i);
                    break;
                }
            }
            if(isPrime)
                System.out.println(i);
        }
    }
}
