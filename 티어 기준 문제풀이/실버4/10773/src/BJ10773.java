import java.util.Scanner;
import java.util.Stack;

public class BJ10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int K = sc.nextInt();
        Stack stack = new Stack();
        for(int i = 0; i<K; i++){
            int temp = sc.nextInt();
            if(temp == 0)
                stack.pop();
            else
                stack.push(temp);
        }
        while(!stack.isEmpty())
            answer += (int)stack.pop();
        System.out.println(answer);
    }
}
