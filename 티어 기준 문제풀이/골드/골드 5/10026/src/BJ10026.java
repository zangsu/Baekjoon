import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ10026 {
    //10:30 ~ 11:30
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineNum = sc.nextInt();
        sc.nextLine();
        Paint paint = new Paint(lineNum);

        for(int l = 0; l<lineNum; l++){
            String line = sc.nextLine();
            char[] colors = line.toCharArray();
            paint.grid[l] = new Color[colors.length];

            for (int i = 0; i<colors.length; i++) {
                paint.grid[l][i] = new Color(l, i, colors[i]);
            }
        }

        Person person = new Person(false, paint);
        Person RgPerson = new Person(true, paint);


        person.search();
        RgPerson.search();

        System.out.println(person.areaNum + " " + RgPerson.areaNum);


    }
}
class Paint{
   Color[][] grid;

   Paint(int n){
       grid = new Color[n][];
   }
}

class Area{
    Queue<Color> search;

    Area(Color color){
        search = new LinkedList<>();
        search.add(color);
    }

    void search(Person person, Paint paint){
        while (search.isEmpty() == false) {
            Color currentColor = search.poll();
            //System.out.println("\npoll : "+ currentColor.toString());
            Color newColor;

            if(currentColor.row > 0){
                newColor = paint.grid[currentColor.row - 1][currentColor.col];
                checkNewColor(person, currentColor, newColor);
            }

            if(currentColor.row < paint.grid.length-1){
                newColor = paint.grid[currentColor.row +1][currentColor.col];
                checkNewColor(person, currentColor, newColor);
            }

            if(currentColor.col > 0){
                newColor = paint.grid[currentColor.row][currentColor.col -1];
                checkNewColor(person, currentColor, newColor);
            }

            if(currentColor.col < paint.grid[0].length-1){
                newColor = paint.grid[currentColor.row][currentColor.col +1];
                checkNewColor(person, currentColor, newColor);
            }
        }
    }

    private void checkNewColor(Person person, Color currentColor, Color newColor) {
        //System.out.println("Check : " + newColor.toString());
        if (person.notUsed.contains(newColor) == false) {
            return;
        }
        if (currentColor.equals(newColor, person)) {
            person.notUsed.remove(newColor);
            search.add(newColor);
            //System.out.println("add Color : "+ newColor.toString());
        }
    }
}
class Color{
    int row;
    int col;
    char color;

    Color(int row, int col, char color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public String toString(){
        return this.row + " " + this.col + " " + this.color;
    }
    boolean equals(Color anotherColor, Person person) {
        if(person.RG){
            if(this.color == 'B'){
                return this.color == anotherColor.color;
            }
            else{
                if(anotherColor.color == 'B')
                    return false;
                else
                    return true;
            }
        }

        else
            return this.color == anotherColor.color;
    }
}
class Person {
    HashSet<Color> notUsed;
    Paint paint;
    boolean RG;
    int areaNum;

    Person(boolean rg, Paint paint){
        notUsed = new HashSet<>();
        this.paint = paint;
        areaNum = 0;
        this.RG = rg;

        for (int i = 0; i< paint.grid.length; i++) {
            for (int j = 0; j < paint.grid[0].length;j++) {
                notUsed.add(paint.grid[i][j]);
            }
        }
    }

    void search(){
        while(!notUsed.isEmpty()){
            areaNum++;
            Color notUsedColor = (Color)notUsed.toArray()[0];
            notUsed.remove(notUsedColor);
            Area area = new Area(notUsedColor);
            area.search(this, paint);
        }
    }
}