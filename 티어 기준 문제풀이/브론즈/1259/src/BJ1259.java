import java.util.Scanner;

public class BJ1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String num = sc.nextLine();
            boolean fen = true;
            if(num.equals("0"))
                break;
            int front = 0;
            int back = num.length()-1;
            while(front < back){
                if (num.charAt(front) != num.charAt(back)) {
                    fen = false;
                    break;
                }
                front++;
                back--;
            }
            if(fen == true)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
