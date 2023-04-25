import java.io.*;
import java.util.*;

public class BJ11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        int list[][] = new int[N][2];
        
        for(int i = 0; i<N; i++){
            String[] line = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(line[0]);
            list[i][1] = Integer.parseInt(line[1]);
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        for(int i = 0; i<N; i++){
            bw.write(list[i][0] + " " + list[i][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}