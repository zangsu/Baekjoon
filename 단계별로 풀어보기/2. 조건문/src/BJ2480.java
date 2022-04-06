import java.util.*;

class BJ2480{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Dice[] = new int[3];
        int Pride;
        for(int i = 0; i<3; i++)
            Dice[i] = sc.nextInt();
        if(Dice[0] == Dice[1]){
            if(Dice[1] == Dice[2])
                Pride = 10000 + 1000*Dice[0];
            else
                Pride = 1000 + 100*Dice[0];
        }
        else{
            int big = Dice[0]>Dice[1]? Dice[0] : Dice[1];
            if(Dice[1] == Dice[2])
                Pride = 1000 + 100*Dice[1];
            else{
                if(Dice[0] == Dice[2])
                    Pride = 1000 + 100*Dice[0];
                else
                {
                    if(Dice[2] > big)
                        big = Dice[2];
                    Pride = big * 100;
                }
            }
        }

        System.out.printf("%d", Pride);
    }
}