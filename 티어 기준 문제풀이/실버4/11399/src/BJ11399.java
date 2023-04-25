import java.util.*;

public class BJ11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int person = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < person; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        for (int i = 0; i < person-1; i++) {
            int cur = list.remove(i+1);
            list.add(i+1, cur + list.get(i));
        }

        for(int num : list)
            sum += num;

        System.out.println(sum);
    }
}
