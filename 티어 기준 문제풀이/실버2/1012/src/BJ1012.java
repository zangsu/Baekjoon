import java.util.*;

public class BJ1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();

        for (int test = 0; test < testNum; test++) {
            //여기서 아직 방문 안한 장소 기억
            ArrayList<Location> notVisit = new ArrayList<>();

            //한 그룹을 계산하기 위한 Queue
            Queue<Location> queue = new LinkedList<Location>();
            int w = sc.nextInt();
            int h = sc.nextInt();
            int loc = sc.nextInt();
            int count = 0;
            int[][] bachu = new int[h][];
            for (int i = 0; i < h; i++) {
                bachu[i] = new int[w];
            }

            for (int i = 0; i < loc; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                bachu[y][x] = 1;
                notVisit.add(new Location(x, y));
            }
            while(notVisit.isEmpty() == false){
                if(queue.isEmpty()){
                    count ++;
                    Location start = notVisit.get(0);
                    notVisit.remove(0);
                    queue.add(start);
                }
                else{
                    Location current = queue.poll();
                    //상
                    if(current.y > 0 && bachu[current.y - 1][current.x] == 1){
                        Location up = new Location(current.x, current.y - 1);
                        if(notVisit.contains(up)) {
                            queue.add(up);
                            notVisit.remove(up);
                        }
                    }
                    //하
                    if(current.y < h-1 && bachu[current.y + 1][current.x] == 1){
                        Location down = new Location(current.x, current.y+1);
                        if(notVisit.contains(down)) {
                            queue.add(down);
                            notVisit.remove(down);
                        }
                    }
                    //좌
                    if(current.x > 0 && bachu[current.y][current.x-1] == 1){
                        Location left = new Location(current.x-1, current.y);
                        if(notVisit.contains(left)) {
                            queue.add(left);
                            notVisit.remove(left);
                        }
                    }
                    //우
                    if(current.x < w-1 && bachu[current.y][current.x+1] == 1){
                        Location right = new Location(current.x+1, current.y);
                        if(notVisit.contains(right)) {
                            queue.add(right);
                            notVisit.remove(right);
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
    static class Location{
        int x;
        int y;
        Location(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x && y == location.y;
        }
    }
}
