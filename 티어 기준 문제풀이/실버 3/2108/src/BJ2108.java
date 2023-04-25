import java.io.*;
import java.util.Arrays;

public class BJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int middleIdx = N/2;
        int maxCount = 0;
        int freq;
        int minFreq = 0;
        int[] list = new int[N];
        int[] count = new int[8001]; // 0 -> -4000, 4000 -> 0, 8000 -> 4000

        for(int i = 0; i<N; i++){
            int number = Integer.parseInt(br.readLine());

            list[i] = number;
            sum+= number;

            count[number + 4000]++;
            if(count[number + 4000] > maxCount) {
                maxCount = count[number + 4000];
                minFreq = number;
            }
            else if(count[number + 4000] == maxCount && minFreq > number)
                minFreq  = number;

        }
        br.close();
        Arrays.sort(list);

        int i = minFreq + 4001;
        for(;i< 8001; i++){
            if(count[i] == maxCount)
                break;
        }

        if(i == 8001)
            freq = minFreq;
        else
            freq = i-4000;

        bw.write(Math.round((float)sum / N) + "\n");
        bw.write(list[middleIdx] + "\n");
        bw.write(freq + "\n");
        bw.write((list[N-1] - list[0]) + "\n");

        bw.flush();
        bw.close();
    }
}
