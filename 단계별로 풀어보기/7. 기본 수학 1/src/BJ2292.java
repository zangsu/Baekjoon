import java.util.*;
class BJ2292{
    public static void main(String[] args){
        //1을 level 1로, 1에서 멀어질 수록 level을 하나씩 올리면
        //각 레벨의 원소 수는 6*level이다.
        //1을 제외하면 각 레벨의 원소 수는 등차수열
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int addNum = 1, sum = 1;
        while(true){
            if(num == 1)
                break;
            sum += addNum*6;
            addNum ++;
            if(sum >= num)
                break;
        }
        System.out.printf("%d", addNum);
    }
}