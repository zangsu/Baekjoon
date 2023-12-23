import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Main {
    static int locationNum;
    static int findDistance;
    static int roadNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        locationNum = Integer.parseInt(input[0]);
        findDistance = Integer.parseInt(input[1]);
        roadNum = Integer.parseInt(input[2]);

        input = br.readLine().split(" ");
        Node[] nodes = new Node[locationNum + 1];
        for (int i = 0; i < locationNum; i++) {
            nodes[i + 1] = new Node(i + 1, Integer.parseInt(input[i]));
        }

        for (int i = 0; i < roadNum; i++) {
            input = br.readLine().split(" ");
            Node node1 = nodes[Integer.parseInt(input[0])];
            Node node2 = nodes[Integer.parseInt(input[1])];
            int distance = Integer.parseInt(input[2]);

            node1.addRoad(node2, distance);
            node2.addRoad(node1, distance);
        }

        int maxItemAmount = Arrays.stream(nodes)
                .filter(Objects::nonNull)
                .mapToInt(Main::findMaxItemAmount)
                .max()
                .getAsInt();

        System.out.print(maxItemAmount);
    }

    private static int findMaxItemAmount(Node startNode) {
        //System.out.println(startNode.index);
        boolean[] visited = new boolean[locationNum + 1];
        visited[startNode.index] = true;
        int result = startNode.itemAmount;

        PriorityQueue<Distance> pq = new PriorityQueue<>();
        startNode.roads.keySet().forEach(
                goalNode -> {
                    Integer distance = startNode.roads.get(goalNode);
                    if (distance <= findDistance) {
                        pq.add(new Distance(goalNode, distance));
                        //visited[goalNode.index] = true;
                    }
                }
        );

        while (!pq.isEmpty()) {
            Distance poll = pq.poll();
            if(visited[poll.goal.index])
                continue;
            result += poll.goal.itemAmount;
            visited[poll.goal.index] = true;
            //System.out.println(poll.goal.index + ", " + poll.distance);

            for (Node nextNode : poll.goal.roads.keySet()) {
                if (visited[nextNode.index]) {
                    continue;
                }
                int distance = poll.distance + poll.goal.roads.get(nextNode);
                if (distance <= findDistance) {
                    pq.add(new Distance(nextNode, distance));
                    //visited[poll.goal.index] = true;
                }
            }
        }
        //System.out.println();

        return result;
    }
}

class Distance implements Comparable<Distance> {
    final Node goal;
    final int distance;

    public Distance(Node goal, int distance) {
        this.goal = goal;
        this.distance = distance;
    }

    @Override
    public int compareTo(Distance o) {
        return this.distance - o.distance;
    }
}

class Node {
    final int index;
    final int itemAmount;
    final Map<Node, Integer> roads = new HashMap<>();

    public Node(int index, int itemAmount) {
        this.index = index;
        this.itemAmount = itemAmount;
    }

    public void addRoad(Node goal, int distance) {
        if (!roads.containsKey(goal) || roads.get(goal) > distance) {
            roads.put(goal, distance);
        }
    }
}
/*
지역 개수 100개
길의 개수 100개

플루이드 - 워셜 : 100 * 100 * 100
다익스트라 : 100 * log(100) * 100

5 15 4
5 7 8 2 3
1 4 5
5 2 4
3 2 3
1 2 3
 */