import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BJ1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        sc.nextLine();
        for(int i = 0;i<n; i++) {
            String line = sc.nextLine();
            if(list.contains(line) == false)
                list.add(line);
        }
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                }
                else{
                    for(int i = 0; i<o2.length(); i++){
                        if(o1.charAt(i) == o2.charAt(i))
                            continue;
                        else
                            return o1.charAt(i) - o2.charAt(i);
                    }
                    return 0;
                }
            }
        };
        list.sort(c);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
