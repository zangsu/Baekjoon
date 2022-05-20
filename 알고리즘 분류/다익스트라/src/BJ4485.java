//백준 - 알고리즘 분류 - 다익스트라
//4485 - 녹색옷 입은 애가 젤다지?
import java.util.*;

public class BJ4485 {
    static class node{
        int row;
        int col;
        int path;
        node(int row, int col, int path){
            this.row = row;
            this.col = col;
            this.path = path;
        }
    }
    static void addList(ArrayList<Integer> r, ArrayList<Integer> c, ArrayList<Integer> p, int row, int col, int path){
        r.add(row);
        c.add(col);
        p.add(path);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caveLength;
        while((caveLength = sc.nextInt()) != 0){
            int[][] cave = new int[caveLength][caveLength];
            int[][] shortestPath = new int[caveLength][caveLength];
            ArrayList<Integer> rowList = new ArrayList<Integer>();
            ArrayList<Integer> colLIst = new ArrayList<Integer>();
            ArrayList<Integer> pathList = new ArrayList<Integer>();

            //동굴 입력받기
            for (int i = 0; i < caveLength; i++)
                for(int j = 0; j<caveLength; j++)
                    cave[i][j] = sc.nextInt();

            addList(rowList, colLIst, pathList, 0, 0, cave[0][0]);
            while(true){
                int min = 0;
                for(int i = 0; i<rowList.size(); i++)
                    if(pathList.get(i)< pathList.get(min) )
                        min = i;
                //이번에 최솟값 중심노드 찾음

            }
        }

    }

}
