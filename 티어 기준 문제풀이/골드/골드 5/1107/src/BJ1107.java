import java.util.HashSet;
import java.util.Scanner;

public class BJ1107 {
    static HashSet<Character> errorButton;
    static char smallestWork;
    static char biggestWork;

    public static void main(String[] args) {
        errorButton = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int nearSmall;
        int nearBig;
        int minDiff;

        int goal = sc.nextInt();
        int errorNum = sc.nextInt();
        sc.nextLine();
        String errorLine = sc.nextLine();
        String[] s = errorLine.split(" ");
        for (String errorChar: s) {
            errorButton.add(errorChar.charAt(0));
        }

        minDiff = Math.abs(goal - 100);


        // == 특수 상황 반환 ==//
        if (goal == 100) {
            System.out.println(0);
            return;
        }
        if (errorNum == 9) {
            System.out.println(goal);
            return;
        }
        if (errorNum == 0) {
            System.out.println(Integer.toString(goal).length());
            return;
        }

        // 제일 가까운 수를 구해서, 차이를 구함?
        for(char num = '0'; num <= '9'; num++){
            if(errorButton.contains(num) == false) {
                smallestWork = num;
                break;
            }
        }

        for(char num = '9'; num >= '0'; num--){
            if(errorButton.contains(num) == false) {
                biggestWork = num;
                break;
            }
        }
        char[] goalCharacter = Integer.toString(goal).toCharArray();

        int errorBit = 0;
        for(; errorBit<goalCharacter.length; errorBit++){
            if(errorButton.contains(goalCharacter[errorBit])){
                break;
            }
        }

        System.out.println("errorBit = " + errorBit);

        if (errorBit == goalCharacter.length) {
            System.out.println(goalCharacter);
            return;
        }

        nearBig = makeBig(goalCharacter, errorBit);
        System.out.println(nearBig);
        nearSmall = makeSmall(goalCharacter, errorBit);
        System.out.println(nearSmall);

        if(nearBig - goal < minDiff)
            minDiff = nearBig - goal;
        if(goal - nearSmall < minDiff)
            minDiff = goal - nearSmall;

        System.out.println(minDiff);

    }

    /*static int makeSmall(char[] goalCharacter, int errorBit){
        String near = "";
        int bit = 0;
        for(;bit<errorBit; bit++){
            near += goalCharacter[bit];
        }

        for(;bit<goalCharacter.length; bit++){
            near += smallestWork;
        }

        return Integer.parseInt(near);
    }*/
    static int makeSmall(char[] goalCharacter){
        boolean errorExist = false;
        String nearString = "";
        int bit = 0;
        while (bit < goalCharacter.length) {
            if(errorButton.contains(goalCharacter[bit]) == false){
                nearString += goalCharacter[bit];
                continue;
            }
            errorExist = true;
            nearString +=
        }

    }
    static int makeBig(char[] goalCharacter, int errorBit){
        char i = goalCharacter[0];
        char[] bigNear = new char[goalCharacter.length+1];
        for(;;i++){
            if(errorButton.contains(i) == false)
                break;
        }

        if(i != 10){
            bigNear[0] = '0';
            bigNear[1] = i;
            for (int bit = 2; bit < bigNear.length; bit++) {
                bigNear[bit] = smallestWork;
            }

            String nearString = "";
            for (int bit = 0; bit < bigNear.length; bit++) {
                nearString += bigNear[bit];
            }

            return Integer.parseInt(nearString);
        }

        else{
            String nearString = "";
            if(smallestWork == '0') {
                for (char small = '1'; small <= '9'; small++)
                    if (errorButton.contains(small) == false) {
                        nearString += small;
                    }
            }
            for (int bit = 0; bit < bigNear.length; bit++) {
                nearString += smallestWork;
            }

            return Integer.parseInt(nearString);
        }
    }
}
