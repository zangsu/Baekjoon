import java.util.Scanner;

public class BJ17288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int count = 0;
        int answer = 0;
        for(int i = 1; i<=line.length(); i++){
            if(i == line.length()){
                if(count == 2)
                    answer++;
            }
            else if(line.charAt(i) == line.charAt(i-1)+1){
                count++;
            }
            else {
                if (count == 2)
                    answer++;
                count = 0;
            }
        }
        System.out.println(answer);
    }
}
