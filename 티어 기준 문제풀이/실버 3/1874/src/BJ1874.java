import java.util.Scanner;
import java.util.Stack;

public class BJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        String answer = "";
        int print = 0;
        int cur = 0;
        int maxCur = 0;
        int des = 0;
        int valid = 0;
        //감소하기 시작하는 순간, 다시 증가하면 안됨
        for(int i = 0; i<num; i++) {
            array[i] = sc.nextInt();
            if(cur < array[i] ) {
                if(des == 0) {
                    cur = maxCur;
                    if(array[i] > maxCur)
                        maxCur = array[i];
                    for (int j = array[i]; j > cur;j--) {
                        answer += "+\n";
                    }
                    answer += "-\n";
                    print++;
                    cur = array[i];
                }
                else {

                    valid = 1;
                }
            }
            else if(array[i] == cur-1){
                cur = array[i];
                answer += "-\n";
                print++;
            }
            else{
                des = 1;
                cur = array[i];
            }
        }
        if(valid == 1)
            System.out.print("NO");
        else{
            for(int i = num - print; i>0; i--) {
                answer += "-";
                if(i>1)
                    answer += "\n";
            }
            System.out.print(answer);
        }
    }
}
