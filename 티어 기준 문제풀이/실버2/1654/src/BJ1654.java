import java.io.*;
import java.util.Arrays;

public class BJ1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int max = 0;
        int term;
        int[] lines = new int[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if(lines[i] > max)
                max = lines[i];
        }

        br.close();

        term = max / 2;
        int min = 1;

        while(true){
            int number  = term + min;
            int sum = 0;
            for(int j = 0; j<K; j++){
                int num = lines[j] / number;
                sum += num;
                if(sum >= N)
                    break;
            }
            if(sum < N){
                if(term == 0)
                    break;
                term /= 2;
                continue;
            }
            if(term == 0)
                min++;
            min = term + min;
            term /= 2;
        }

        bw.write(Integer.toString(min-1));

        bw.flush();
        bw.close();
    }
}
