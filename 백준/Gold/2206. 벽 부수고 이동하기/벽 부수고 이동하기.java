import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private static final int NO_BREAK = 0;
    private static final int BREAK = 1;
    private static final int[] dy = new int[]{-1, 1, 0, 0};
    private static final int[] dx = new int[]{0, 0, 1, -1};
    public static final int NO_PATH = 1_000_000;

    private static int rowNum;
    private static int colNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        rowNum = Integer.parseInt(input[0]);
        colNum = Integer.parseInt(input[1]);

        int[][] map = initMap(br);
        int[][][] costMap = initCostMap();
        boolean cont = true;

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(new Node(0, 0));
        costMap[0][0][NO_BREAK] = 1;

        while(!nodes.isEmpty() && cont){
            Node poll = nodes.poll();
            for (int i = 0; i < 4; i++) {
                int row = poll.row + dy[i];
                int col = poll.col + dx[i];
                if (row < 0 || row >= rowNum || col < 0 || col >= colNum) {
                    continue;
                }

                int[] prevCost = costMap[poll.row][poll.col];
                if (map[row][col] == WALL) {
                    if (prevCost[NO_BREAK] + 1 < costMap[row][col][BREAK]) {
                        costMap[row][col][BREAK] = prevCost[NO_BREAK] + 1;
                        nodes.add(new Node(row, col));
                    }
                }
                if (map[row][col] == EMPTY) {
                    if (prevCost[NO_BREAK] + 1 < costMap[row][col][NO_BREAK]) {
                        costMap[row][col][NO_BREAK] = prevCost[NO_BREAK] + 1;
                        nodes.add(new Node(row, col));
                    }
                    if (prevCost[BREAK] + 1 < costMap[row][col][BREAK]) {
                        costMap[row][col][BREAK] = prevCost[BREAK] + 1;
                        nodes.add(new Node(row, col));
                    }
                }

                if (costMap[rowNum - 1][colNum - 1][BREAK] != NO_PATH
                        || costMap[rowNum - 1][colNum - 1][NO_BREAK] != NO_PATH) {
                    cont = false;
                    break;
                }
            }
        }

        int cost = Math.min(costMap[rowNum-1][colNum-1][BREAK], costMap[rowNum-1][colNum-1][NO_BREAK]);
        if(cost == NO_PATH){
            System.out.println(-1);
        }
        else{
            System.out.println(cost);
        }

    }

    private static int[][] initMap(BufferedReader br) throws IOException {
        String[] input;
        int[][] map = new int[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            input = br.readLine().split("");
            for (int col = 0; col < colNum; col++) {
                map[row][col] = Integer.parseInt(input[col]);
            }
        }
        return map;
    }

    private static int[][][] initCostMap() {
        int[][][] costMap = new int[rowNum][colNum][2];

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                costMap[row][col][NO_BREAK] = NO_PATH;
                costMap[row][col][BREAK] = NO_PATH;
            }
        }
        return costMap;
    }

}
/*
5 5
01000
00010
11100
00001
00001

ans: 5
 */
class Node{
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    int row;
    int col;
}