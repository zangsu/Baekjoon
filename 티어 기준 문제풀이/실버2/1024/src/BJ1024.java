import java.util.*;

public class BJ1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int len = sc.nextInt();
        boolean find = false;

        int start = 0;
        while(find != true && len < 101){
            int curSum = calSum(start, start + len - 1);
            if(curSum == sum)
                find = true;
            else if(start == 0 && curSum > sum)
                break;
            else if(start != 0 && curSum > sum){
                start = 0;
                len++;
            }
            else{
                start++;
            }
        };
        if(find == false)
            System.out.println(-1);
        else{
            for(int i = start; i<start + len; i++)
                System.out.print(i + " ");
        }
    }
    static int calSum(int start, int end){
        int a = start * (start - 1) / 2;
        int b = end * (end + 1) / 2;

        return b - a;
    }
}
