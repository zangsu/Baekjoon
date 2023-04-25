import java.io.*;
import java.util.*;

public class BJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);

        for (Integer integer : list) {
            bw.write(integer.toString());
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        /**
         * sort 구현해야 하나봄
         * quicksort
         */
    }
}
