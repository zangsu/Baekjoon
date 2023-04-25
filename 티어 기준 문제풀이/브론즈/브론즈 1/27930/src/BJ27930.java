import java.util.Scanner;

public class BJ27930 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] yonseiArray = "YONSEI".toCharArray();
        char[] korArray = "KOREA".toCharArray();
        int yonIdx = 0;
        int korIdx = 0;

        String line = sc.nextLine();

        int idx = 0;
        while (yonIdx < yonseiArray.length && korIdx < korArray.length) {
            if(line.charAt(idx) == yonseiArray[yonIdx])
                yonIdx++;
            if(line.charAt(idx) == korArray[korIdx])
                korIdx++;
            idx++;
        }

        if(yonIdx == yonseiArray.length)
            System.out.println("YONSEI");
        else
            System.out.println("KOREA");

    }
}
