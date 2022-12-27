import java.util.Scanner;

public class BJ2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int loc = Integer.toString(num).length();
        int i = num - (9 * loc);
        for(;i<=num; i++){
            int sum = i;
            String n = Integer.toString(i);
            for(int j = 0; j<n.length(); j++){
                sum += n.charAt(j) - '0';
            }
            if(sum == num)
                break;
        }
        if(i > num)
            System.out.println(0);
        else
            System.out.println(i);
    }
}
