import java.util.*;

public class BJ14888 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int[] Instuction = new int[4];

        int num = sc.nextInt();
        for(int i = 0; i<num; i++)
            numList.add(sc.nextInt());
        for(int i = 0; i<4; i++)
            Instuction[i] = sc.nextInt();

    }
}
