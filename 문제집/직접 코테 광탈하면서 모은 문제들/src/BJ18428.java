import java.util.*;

/* @input : int N(3~6) -> 복도의 크기
 *          S = student
 *          T = teacher
 *          X = blank
 *
 *          장애물 : 3개 이하
 */

public class BJ18428 {
    static class inteval{
        int start;
        int end;
        inteval(int a, int b){
            this.start = a;
            this.end = b;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, inteval> ver = new HashMap<>();
        HashMap<Integer, inteval> hor = new HashMap<>();

        int N = sc.nextInt();
        String Line = "";
        int start = 0;
        String[][] hall = new String[N][N];

        for (int i = 0; i < N; i++) {
            for(int j = 0; j<N; j++) {
                if(j == 0)
                    Line = "";
                hall[i][j] = sc.nextLine();
                if(hall[i][j].equals("S")) {
                    if(Line.equals("") || Line.equals("S")) {
                        Line = "S";
                        start = j;
                    }
                    else if(Line.equals("T")) {
                        ver.put(i, new inteval(start, j));
                        Line = "S";
                        start = j;
                    }
                }
                else if (hall[i][j].equals("T")) {
                    if (Line.equals("") || Line.equals("T")) {
                        Line = "T";
                        start = j;
                    }
                    else if(Line.equals("S")) {
                        ver.put(i, new inteval(start, j));
                        Line = "T";
                        start = j;
                    }
                }
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){

            }
        }




    }
}

/* 아이디어 : hashset으로 벽을 세우기 전 연결되는 선생과 학생을 저장
            ex ) 선생이 (2,4) 학생이 (4,4) 면 (1, 2, 4, 4, 4) -> 1은 세로, 0은 가로
   아니면
   (1, 4, 2, 3) 이면 2,4나 3,4에 벽 설치 요망
 *
 */

/*
XXSSX
TXXXS
XTXXS
XXTTX
XXXXX
 */