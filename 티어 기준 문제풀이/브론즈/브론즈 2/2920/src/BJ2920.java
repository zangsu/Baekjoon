import java.util.Scanner;

public class BJ2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean asc = true;
        boolean des = true;
        int[] sound = new int[8];
        for(int i = 0; i<8; i++){
            sound[i] = sc.nextInt();
            if(sound[i] != i+1)
                asc = false;
            if(sound[i] != 8-i)
                des = false;
        }

        if(asc == true)
            System.out.println("ascending");
        else if(des == true)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
