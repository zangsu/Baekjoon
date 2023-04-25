import java.util.*;
import java.io.*;
public class BJ18111 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);
        int min = 256;
        int max = 0;
        int time = 0;
        int pivot;
        int correctPivot;

        HashMap<Integer, Integer> land = new HashMap<>();
        for(int i = 0; i<N; i++){
            String[] lines = br.readLine().split(" ");
            for(int j = 0; j<M; j++){
                int h = Integer.parseInt(lines[j]);
                if(land.containsKey(h))
                    land.put(h, land.get(h) + 1);
                else
                    land.put(h, 1);
                if(h < min)
                    min = h;
                if(h > max)
                    max = h;
            }
        }
        if(min == max){
            bw.write( 0 + " " + max);
            bw.flush();
            bw.close();
            return;
        }
        pivot = max;
        correctPivot = pivot;

        while(pivot >= min){
            //bw.write("pivot : " + pivot + "  ");
            int block = B;
            int newTime = 0;
            boolean isWork = true;
            for(int work = max; work >= min; work--){
                if (land.containsKey(work) == false)
                    continue;
                int hNum = land.get(work);
                if(work > pivot){
                    int diff = work - pivot;
                    block += hNum * diff;
                    newTime += (diff * hNum*2);
                }
                if(work < pivot) {
                    int diff = pivot - work;
                    if(block < hNum * diff){
                        isWork = false;
                        break;
                    }
                    block -= (hNum * diff);
                    newTime += (hNum * diff);
                }
            }
            if(isWork == false) {
                pivot --;
                continue;
            }
            if(time == 0) {//다 같은 경우가 있다면 문제
                time = newTime;
                correctPivot = pivot;
            }
            if(newTime < time) {
                time = newTime;
                correctPivot = pivot;
            }
            //bw.write(newTime + " : " + pivot + "\n");
            pivot--;
        }
        bw.write(time + " " + correctPivot);
        bw.flush();
        bw.close();
    }
}