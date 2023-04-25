import java.util.Scanner;
import java.util.Stack;

public class BJ4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean needNewInput = true;
        Stack<Character> stack = new Stack<>();
        while(true){
            boolean balanced = true;
            String line = sc.nextLine();
            //System.out.println("line = " + line);
            if(needNewInput)
                stack = new Stack<>();
            if(line.equals("."))
                break;
            if(line.contains("."))
                needNewInput = true;
            else
                needNewInput = false;
            for(int i = 0; i<line.length() && balanced; i++){
                char c = line.charAt(i);
                if(c == '(' || c == '[')
                    stack.push(c);
                else if(c == ')'){
                    if(stack.isEmpty() == false && stack.pop() == '(')
                        continue;
                    else
                        balanced = false;
                }
                else if(c == ']'){
                    if(stack.isEmpty() == false &&stack.pop() == '[')
                        continue;
                    else
                        balanced = false;
                }
            }
            if(needNewInput == true) {
                if (stack.isEmpty() == false)
                    balanced = false;
                if (balanced == true)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }
    }
}
