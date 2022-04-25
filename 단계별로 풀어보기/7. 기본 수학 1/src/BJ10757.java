import java.awt.*;
import java.util.*;
public class BJ10757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String answer = "";
        int i= 1, carry = 0;

        while(i <= B.length() && i<=A.length()){
            int Achar, Bchar;
            Achar = A.charAt(A.length()-i) - '0';
            Bchar = B.charAt(B.length() - i) - '0';
            int tempNumber = carry + Achar + Bchar;
            if(tempNumber >= 10){
                carry = tempNumber/10;
                tempNumber%=10;
            }
            else
                carry = 0;

            answer = String.valueOf(tempNumber) + answer;
            i++;
        }
        if(carry != 0) {
            if(B.length() == A.length())
                answer = String.valueOf(carry) + answer;
            else{
                if(A.length() > B.length())
                    while(i <= A.length())
                        answer = A.charAt(A.length() - i++) + answer;
                else
                    while(i <= B.length())
                        answer = B.charAt(B.length()- i++) + answer;
            }
        }
        System.out.println(answer);

    }
}
