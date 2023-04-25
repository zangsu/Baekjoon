import java.util.Scanner;

public class BJ1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 0;
        int count = 0;
        while(count < N){
            if(Integer.toString(i).contains("666"))
                count++;
            i++;
        }
        System.out.println(i-1);
    }
}
