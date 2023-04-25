import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BJ10828 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int num = sc.nextInt();
        int num = 0;
        num = Integer.parseInt(br.readLine());
        //sc.nextLine();

        //int top = 0;
        //int[] stack = new int[num];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<num; i++){
            String op = br.readLine();
            switch (op){
                case "pop":
                    if(stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "top":
                    if(stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.peek());
                    break;
                default:
                    int number = Integer.parseInt(op.split(" ")[1]);
                    stack.push(number);
                    break;
            }
        }
    }
}
