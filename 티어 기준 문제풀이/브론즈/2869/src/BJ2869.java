import java.io.*;

public class BJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        br.close();
        int climb_dist = Integer.parseInt(input[0]);
        int fall_dist = Integer.parseInt(input[1]);
        int goal_dist = Integer.parseInt(input[2]);
        int real_climb = climb_dist - fall_dist;

        int finalHeight = goal_dist - climb_dist;
        int neededDay = finalHeight / real_climb;
        if(finalHeight % real_climb > 0)
            neededDay++;

        bw.write(Integer.toString(neededDay + 1));

        bw.flush();
        bw.close();

    }

}
