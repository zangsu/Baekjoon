import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class BJ10816  {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }
            else
                map.put(s, 1);
        }

        int m = Integer.parseInt(br.readLine());
        array = br.readLine().split(" ");
        for (String s : array) {
            bw.write(Integer.toString(map.getOrDefault(s, 0)));
            bw.write(" ");
        }
        bw.flush();
        bw.close();

    }
}
