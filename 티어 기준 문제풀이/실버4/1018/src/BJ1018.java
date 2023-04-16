import java.util.Scanner;

public class BJ1018 {
    public static void main(String[] args) {
        // 1:42 ~ 2:32
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        int[][] diff = new int[col][row];
        int[][] DP = new int[col][row];
        char[] color = { 'W', 'B'};
        sc.nextLine();

        char[][] chess = new char[col][row];
        for(int i = 0; i<col; i++){
            String column = sc.nextLine();
            chess[i] = column.toCharArray();
        }


        for(int i = 0; i<col; i++){
            for(int j = 0; j<row; j++){
                if(chess[i][j] != color[(i + j)%2])
                    diff[i][j] = 1;
            }
        }

        for(int i = 0; i<col; i++){ //각 줄의 8개 연속의 다시 칠해야 하는 수 구하기
            for(int j = 0; j<row; j++){
                if(j == 0){
                    DP[i][0] = diff[i][0];
                }
                else{
                    DP[i][j] = DP[i][j-1] + diff[i][j];
                    if(j > 7)
                        DP[i][j] -= diff[i][j-8];
                }
            }
        }

        int[][] newDP = new int[col][row];

        for(int i = 0; i<col; i++){
            for(int j = 7; j<row; j++){
                if(i == 0)
                    newDP[0][j] = DP[0][j];
                else{
                    newDP[i][j] = DP[i][j] + newDP[i-1][j];
                }
                if(i > 7){
                    newDP[i][j] -= DP[i-8][j];
                }
            }
        }

        /*for(int i = 0; i<col; i++){
            for(int j = 0; j<row; j++){
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }*/

        /*for(int i = 7; i<col; i++){
            for(int j = 7; j<row; j++){
                System.out.print(newDP[i][j] + " ");
            }
            System.out.println();
        }*/

        int min = newDP[7][7];
        for(int i = 7; i<col; i++){
            for(int j = 7; j<row; j++){
                if(newDP[i][j] > 32)
                    newDP[i][j] = 64 - newDP[i][j];
                if(newDP[i][j] < min)
                    min = newDP[i][j];
            }
        }

        System.out.println(min);


    }
}

/**
 * 계속해서 반복되는 구간을 최대한 많이 포함시키는 것이 유리
 *
 */