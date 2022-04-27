import java.util.*;

public class BJ1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int herex = sc.nextInt(), herey = sc.nextInt();
        int limx = sc.nextInt(), limy = sc.nextInt();
        int smallx = herex<limx-herex ? herex : limx-herex;
        int smally = herey<limy-herey? herey: limy-herey;
        System.out.printf("%d", smallx<smally? smallx: smally);
    }
}
