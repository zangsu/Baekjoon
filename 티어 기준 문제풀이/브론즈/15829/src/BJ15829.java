import jdk.jfr.Unsigned;

import java.util.Scanner;

public class BJ15829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        Long cn = Integer.toUnsignedLong('a'-1);
        int HashNum = 1234567891;
        Long sum = 0L;
        Long r = 1L;
        String line = sc.nextLine();
        for(int i = 0; i<line.length(); i++){

            Long temp = 0L;
            temp = line.charAt(i) - cn;

            temp *= r;
            if(temp > HashNum)
                temp%= HashNum;

            sum+=(temp);
            if(sum > HashNum)
                sum %= HashNum;
            r *= 31;
            if(r > HashNum)
                r %= HashNum;
        }
        System.out.println(sum);
    }
}