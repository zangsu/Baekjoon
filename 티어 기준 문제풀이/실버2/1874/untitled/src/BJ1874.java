import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BJ1874 {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int currentNumber = 1;

        for(int i = 0; i<n; i++){
            int number = sc.nextInt();
            //System.out.println(number + ":");
            while(currentNumber <= number){
                stack.push(currentNumber);
                list.add("+");
                currentNumber++;
            }
            if(stack.peek() == number){
                stack.pop();
                list.add("-");
            }
            else{
                System.out.println("NO");
                //System.out.println("Expect : " + number + " value : " + stack.peek());
                return;
            }
        }

        while(stack.isEmpty() == false){
            list.add("-");
        }

        for(int i = 0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
}
