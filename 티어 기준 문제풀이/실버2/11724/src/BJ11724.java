import java.util.*;

public class BJ11724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int line = sc.nextInt();
        ArrayList<Integer> isVisited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int conNum = 0;
        int[][] conn = new int[node+1][];
        for(int i = 1; i<=node; i++) {
            conn[i] = new int[node+1];
            isVisited.add(i);
        }
        for(int i = 0; i<line; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            conn[a][b] = 1;
            conn[b][a] = 1;
        }

        while (isVisited.isEmpty() == false) {
            int start = isVisited.get(0);
            isVisited.remove(isVisited.indexOf(start));
            queue.add(start);
            while(queue.isEmpty() == false){
                int cur = queue.poll();
                for(int i = 1; i<=node; i++){
                    if(conn[cur][i] == 1 && isVisited.contains(i)){
                        queue.add(i);
                        isVisited.remove(isVisited.indexOf(i));
                    }
                }
            }
            conNum++;
        }

        System.out.println(conNum);

    }
}
