import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BJ11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Location> list = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Location(a, b));
        }
        Comparator<Location> locCom = new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                if(o1.x != o2.x)
                    return o1.x - o2.x;
                else if(o1.y != o2.y)
                    return o1.y - o2.y;
                else
                    return 0;
            }
        };

        list.sort(locCom);

        for (Location location : list) {
            System.out.println(location.x + " " + location.y);
        }

    }
    static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
