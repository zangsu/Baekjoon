import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{

    private static final int MAX_TIME = 101;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int nodeNum = Integer.parseInt(input[0]);
        int edgeNum = Integer.parseInt(input[1]);
        int partyCity = Integer.parseInt(input[2]);
        int[][] costs = new int[nodeNum + 1][nodeNum + 1];
        for (int i = 1; i < nodeNum + 1; i++) {
            Arrays.fill(costs[i], MAX_TIME);
        }

        for (int edge = 0; edge < edgeNum; edge++) {
            input = br.readLine().split(" ");
            int startNode = Integer.parseInt(input[0]);
            int endNode = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            costs[startNode][endNode] = cost;
        }

        /*for (int i = 1; i <= nodeNum; i++) {
            for (int j = 1; j <= nodeNum; j++) {
                System.out.print(costs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

        int[] toHome = dijkstra(partyCity, costs);

        /*for (int i = 1; i <= nodeNum; i++) {
            System.out.print(toHome[i] + " ");
        }*/

        int maxTime = 0;
        for (int i = 1; i <= nodeNum; i++) {
            int[] toParty = dijkstra(i, costs);
            if(toParty[partyCity] + toHome[i] > maxTime)
                maxTime = toParty[partyCity] + toHome[i];
        }
        System.out.println(maxTime);
    }

    private static int[] dijkstra(int start, int[][] costs) {
        int size = costs.length;
        int[] results = new int[size];
        int remainNode = size - 2;
        PriorityQueue<Cost> pq = new PriorityQueue<>();
        for (int i = 1; i < size; i++) {
            if(i == start || costs[start][i] == MAX_TIME)
                continue;
            pq.add(new Cost(i, costs[start][i]));
        }

        while(remainNode > 0){
            Cost poll = pq.poll();
            if(results[poll.dest] != 0)
                continue;
            results[poll.dest] = poll.cost;

            for (int dest = 1; dest < size; dest++) {
                if(dest == start)
                    continue;
                if(costs[poll.dest][dest] == MAX_TIME)
                    continue;
                pq.add(new Cost(dest, costs[poll.dest][dest] + poll.cost));
            }
            remainNode--;
        }

        return results;
    }
}

class Cost implements Comparable<Cost>{
    int dest;
    int cost;

    public Cost(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Cost o) {
        return this.cost - o.cost;
    }
}