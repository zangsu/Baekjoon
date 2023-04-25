import java.util.Scanner;
import java.util.Stack;

public class BJ9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = Integer.parseInt(sc.nextLine());


        for(int i = 0; i<TestCase; i++){
            String VPS = sc.nextLine();
            int Answer = 1;
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j<VPS.length(); j++){
                if(VPS.charAt(j) == '('){;
                    stack.push('(');
                }
                else{
                    if(stack.isEmpty()){
                        Answer = 0;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty() == true && Answer == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}