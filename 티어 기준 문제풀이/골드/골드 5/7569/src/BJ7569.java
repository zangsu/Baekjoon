import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7569 {
    //9:40
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int yetCount = 0;
        int day = 0;
        Box box = new Box(m, n, h);

        for (int height = 0; height < h; height++) {
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < m; row++) {
                    int tomatoState = sc.nextInt();
                    if(tomatoState == -1){
                        box.tomatoes[row][col][height] = null;
                        continue;
                    }
                    box.tomatoes[row][col][height] = new Tomato(row, col, height, tomatoState);
                    if(tomatoState == 1){
                        box.yesterdayDone.add(box.tomatoes[row][col][height]);
                    }
                    else
                        yetCount++;
                }
            }
        }
        box.setYetCount(yetCount);

        while(box.yetCount > 0 && !box.yesterdayDone.isEmpty()){
            day++;
            box.afterDay();
        }

        if (box.yetCount != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(day);
    }

}
class Tomato{
    int x;
    int y;
    int h;
    boolean done;

    Tomato(int x, int y, int h, int done) {
        this.x = x;
        this.y = y;
        this.h = h;
        if (done == 1) {
            this.done = true;
        }
        else
            this.done = false;
    }


    void doneTomato(){
        this.done = true;
    }
}
class Box{
    int m;
    int n;
    int h;
    Tomato[][][] tomatoes;
    Queue<Tomato> yesterdayDone;
    int yetCount;

    Box(int m, int n, int h){
        tomatoes = new Tomato[m][n][h];
        yesterdayDone = new LinkedList<>();
    }
    void setYetCount(int yetCount){
        this.yetCount = yetCount;
    }

    void afterDay(){
        int workTomatoSize = yesterdayDone.size();
        for(int tomatoWork = 0; tomatoWork < workTomatoSize; tomatoWork++){
            Tomato workTomato = yesterdayDone.poll();
            checkTomatoAround(workTomato);
        }
    }

    void checkTomatoAround(Tomato workTomato){
        Tomato checkedTomato;

        if(workTomato.x > 0) {
            checkedTomato = tomatoes[workTomato.x - 1][workTomato.y][workTomato.h];
            checkTomato(checkedTomato);
        }

        if(workTomato.x < tomatoes.length-1){
            checkedTomato = tomatoes[workTomato.x + 1][workTomato.y][workTomato.h];
            checkTomato(checkedTomato);
        }

        if(workTomato.y > 0){
            checkedTomato = tomatoes[workTomato.x][workTomato.y - 1][workTomato.h];
            checkTomato(checkedTomato);
        }

        if(workTomato.y < tomatoes[0].length-1){
            checkedTomato = tomatoes[workTomato.x][workTomato.y + 1][workTomato.h];
            checkTomato(checkedTomato);
        }

        if(workTomato.h > 0){
            checkedTomato = tomatoes[workTomato.x][workTomato.y][workTomato.h - 1];
            checkTomato(checkedTomato);
        }

        if(workTomato.h < tomatoes[0][0].length-1){
            checkedTomato = tomatoes[workTomato.x][workTomato.y][workTomato.h + 1];
            checkTomato(checkedTomato);
        }
    }

    private void checkTomato(Tomato checkTomato) {
        if(checkTomato == null)
            return;
        if (checkTomato.done == false) {
            checkTomato.doneTomato();
            yesterdayDone.add(checkTomato);
            yetCount--;
        }
    }
}