import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        br.close();
        int cur = -1;
        //bw.write("<");
        sb.append("<");
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i<=N; i++)
            list.add(i);
        while(true){
            cur += K;
            if(cur >= list.size())
                cur %= list.size();
            int num = list.remove(cur--);
           sb.append(num);
            if(list.size() > 0)
                sb.append(", ");
            else
                break;
        }
        sb.append(">");
        System.out.println(sb);
    }
}
