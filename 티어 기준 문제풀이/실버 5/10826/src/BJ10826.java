import java.util.Scanner;

public class BJ10826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Long num0 = 0L;
        Long num1 = 1L;
        Long num2 = 1L;
        switch(n){
            case 0 :
                System.out.println(0);
                break;
            case 1:
            case 2:
                System.out.println(1);
                break;
            default:
                for(int i = 3; i<=n; i++){
                    switch(i%3){
                        case 0:
                            num0 = num1 + num2;
                            if(i == n)
                                System.out.println(num0);
                            break;
                        case 1:
                            num1 = num2 + num0;
                            if(i == n)
                                System.out.println(num1);
                            break;
                        case 2:
                            num2 = num1 + num0;
                            if(i == n)
                                System.out.println(num2);
                            break;
                    }
                }
        }

    }
}
