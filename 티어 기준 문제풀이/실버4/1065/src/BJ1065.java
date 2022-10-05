import java.util.Scanner;

public class BJ1065 {
    public static void main(String[] args) {
        //한자리, 두자리 수는 무조건 한수이다.

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        System.out.println(Solver(number));

    }
    static int Solver(int number){
        if(number < 100)
            return number;
        else{
            int answer = 99;
            int cont = 1;

            for(int first = 1; first < 10 && cont == 1; first++){
                for(int second = 0; second < 10 && cont == 1; second++){
                    for(int last = 0; last < 10 && cont == 1; last++){
                        if(100*first + 10*second + last > number) {
                            cont = 0;
                            break;
                        }
                        if(first - second == second - last)
                            answer++;
                    }
                }
            }

            return answer;
        }
    }
}