import java.util.*;
class Apartment{
    int SumPeople(int floor, int Room){
        if(floor == 0)
            return Room;
        else if(Room == 1)
            return 1;
        else
            return SumPeople(floor-1, Room) + SumPeople(floor, Room-1);
    }
}
public class BJ2775 {

    public static void main(String[] args) {
        Apartment a = new Apartment();
        Scanner sc = new Scanner(System.in);
        int Test = sc.nextInt();

        for(int i = 0; i<Test; i++)
        {
            int floor = sc.nextInt();
            int Room = sc.nextInt();
            System.out.printf("%d\n", a.SumPeople(floor, Room));
        }
    }
}
