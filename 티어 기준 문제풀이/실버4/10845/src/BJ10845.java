import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class BJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOp = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i<numOp; i++){
            String[] line = br.readLine().split(" ");
            switch (line[0]){
                case "push" :
                    int num = Integer.parseInt(line[1]);
                    q.add(num);
                    break;
                case "pop":
                    if(q.size() == 0)
                        System.out.println(-1);
                    else
                        System.out.println(q.remove(0));
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.size() == 0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front":
                    if(q.size() == 0)
                        System.out.println(-1);
                    else
                        System.out.println(q.get(0));
                    break;
                case "back":
                    if(q.size() == 0 )
                        System.out.println(-1);
                    else
                        System.out.println(q.get(q.size()-1));
                    break;
            }
        }
    }
}
