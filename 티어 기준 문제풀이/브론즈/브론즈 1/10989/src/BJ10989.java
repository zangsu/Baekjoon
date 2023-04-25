import java.io.*;
import java.util.*;

public class BJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i<size; i++) {
            int input = Integer.parseInt(br.readLine());
            if(count.containsKey(input)){
                count.put(input, count.get(input) + 1);
            }
            else{
                count.put(input, 1);
            }
        }
        br.close();

        for(int i = 1; i<=10000; i++){
        //while (queue.isEmpty() == false) {
            if(count.containsKey(i) == false)
                continue;
            int numberNum = count.get(i);

            for (int j = 0; j< numberNum; j++) {
                bw.write(Integer.toString(i) + "\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
