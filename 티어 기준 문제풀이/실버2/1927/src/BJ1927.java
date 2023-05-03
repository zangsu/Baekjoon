import java.io.*;
import java.util.PriorityQueue;

public class BJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            int number = Integer.parseInt(br.readLine());
            if(number != 0){
                minHeap.add(number);
                continue;
            }

            if(minHeap.isEmpty()) {
                bw.write("0\n");
                continue;
            }

            Integer min = minHeap.poll();
            bw.write(min + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
