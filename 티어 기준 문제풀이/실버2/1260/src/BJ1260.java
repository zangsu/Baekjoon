import java.util.*;

public class BJ1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node =  sc.nextInt();
        int line = sc.nextInt();
        int startNode = sc.nextInt();
        int[] visited = new int[node+1];
        int curNode = startNode;
        Stack<Integer> stack= new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        int[][] con = new int[node+1][];
        for (int i = 1; i < node+1; i++) {
            visited[i] = 0;
            con[i] = new int[node+1];
            for(int j = 1; j<node+1; j++)
                con[i][j] = 0;
        }
        for (int i = 0; i < line; i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();
            con[firstNode][secondNode] = 1;
            con[secondNode][firstNode] = 1;
        }

        /**
         * DFS 구현
         * 현재 노드는 stack에서 Pop 시켜서 가져온다.
         * 현재 노드와 연결 된 모든 노드를 stack에 넣는다.
         * 현재 노드를 출력한다.
         */
        stack.push(startNode);
        while(stack.isEmpty() == false){
            curNode = stack.pop();
            for(int i = node; i>0; i--){
                if(con[curNode][i] == 1 && visited[i] == 0){
                    stack.push(i);
                }
            }
            if(visited[curNode] == 0) {
                visited[curNode] = 1;
                System.out.print(curNode + " ");
            }
        }
        System.out.println();
        for(int i = 1; i <= node; i++)
            visited[i] = 0;
        /**
         * BFS 구현
         * Queue 사용
         */
        queue.add(startNode);
        visited[startNode] = 1;
        while (queue.isEmpty() == false) {
            curNode = queue.poll();
            for(int i = 1; i<= node; i++){
                if(visited[i] == 0 && con[curNode][i] == 1){
                    queue.add(i);
                    visited[i] = 1;
                }
            }
            System.out.print(curNode + " ");

        }
    }
}
