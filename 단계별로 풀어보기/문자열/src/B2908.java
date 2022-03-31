import java.util.*;

public class B2908 {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int ta = a;
       int tb = b;
       int big = 0;
       while(ta > 0)
       {
           if (ta % 10 == tb % 10) {
               ta /= 10;
               tb /= 10;
               continue;
           }
           big = (ta % 10 > tb % 10) ? a : b;
           break;
       }
       if(big == 0)
           big = a;
       for(int i = 0; i<3; i++)
       {
           System.out.printf("%d", big%10);
           big/=10;
       }
   }

}
