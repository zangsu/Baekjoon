import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum Space {
    EMPTY("0"),
    WALL("1"),
    VIRUS("2");
    private static final Map<String, Space> CACHED_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(space -> space.input, Function.identity()));

    private final String input;

    Space(String input) {
        this.input = input;
    }

    static final Space of(String input) {
        return Optional.ofNullable(CACHED_MAP.get(input.trim()))
                .orElseThrow(RuntimeException::new);
    }

}

public class Main {

    private static final int WALL_NUM = 3;
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static final List<Location> virusLocations = new LinkedList<>();
    private static Space[][] map;
    private static int rowNum;
    private static int colNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        rowNum = Integer.parseInt(input[0]);
        colNum = Integer.parseInt(input[1]);

        map = new Space[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            input = br.readLine().split(" ");
            for (int col = 0; col < colNum; col++) {
                map[row][col] = Space.of(input[col]);
                if (map[row][col] == Space.VIRUS) {
                    virusLocations.add(new Location(row, col));
                }
            }
        }

        int maxSafeArea = IntStream.range(0, rowNum * colNum)
                .filter(Main::isEmpty)
                .map((num) -> dfs(1, new LinkedList<>(List.of(num))))
                .max()
                .getAsInt();

        System.out.println(maxSafeArea);

    }

    private static int dfs(int depth, LinkedList<Integer> locations) {

        if (depth == 3) {

            //List<Location> newWall =
            locations.stream()
                    .map(Main::LocationOf)
                    //.collect(Collectors.toList());
                    .forEach(location -> map[location.row][location.col] = Space.WALL);

            Queue<Location> viruses = new LinkedList<>(virusLocations);

            boolean[][] visited = new boolean[rowNum][colNum];
            virusLocations
                    .forEach(location -> visited[location.row][location.col] = true);
            while (!viruses.isEmpty()) {
                Location poll = viruses.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = poll.row + dy[i];
                    int nextCol = poll.col + dx[i];
                    if (nextRow < 0 || nextCol < 0 || nextCol >= colNum
                            || nextRow >= rowNum) {
                        continue;
                    }
                    if (!visited[nextRow][nextCol]) {
                        if (map[nextRow][nextCol] == Space.EMPTY) {
                            viruses.add(new Location(nextRow, nextCol));
                        }
                        visited[nextRow][nextCol] = true;
                    }
                }
            }

            int count = 0;
            for (int row = 0; row < rowNum; row++) {
                for (int col = 0; col < colNum; col++) {
                    if (!visited[row][col] && map[row][col] == Space.EMPTY) {
                        count++;
                    }
                }
            }

            locations.stream()
                    .map(Main::LocationOf)
                    //.collect(Collectors.toList());
                    .forEach(location -> map[location.row][location.col] = Space.EMPTY);
            /*System.out.println(depth);
            locations.forEach(
                    integer -> System.out.print(integer + " ")
            );
            System.out.println("count : " + count);
            System.out.println();*/
            return count;
        }

        Integer lastIndex = locations.get(locations.size() - 1);
        return IntStream.range(lastIndex + 1, rowNum * colNum)
                .filter(Main::isEmpty)
                .map((num) -> {
                    locations.addLast(num);
                    int area = dfs(depth + 1, locations);
                    locations.removeLast();
                    return area;
                })
                .max()
                .orElse(0);

    }

    private static boolean isEmpty(int index) {
        Location location = LocationOf(index);
        return map[location.row][location.col] == Space.EMPTY;
    }

    private static Location LocationOf(int index) {
        return new Location(index / colNum, index % colNum);
    }
}

/*class LocationGenerator {
    private static final Location FIRST_LOCATION = new Location(0, 0);
    private List<Location> locations;
    private final int maxRow;
    private final int maxCol;

    LocationGenerator(int maxRow, int maxCol) {
        locations = List.of(FIRST_LOCATION,
                FIRST_LOCATION.next(maxRow, maxCol),
                FIRST_LOCATION.next(maxRow, maxCol).next(maxRow, maxCol)
        );
        this.maxRow = maxRow;
        this.maxCol = maxCol;
    }

    public void next(){

    }



}*/

class Location {
    int row;
    int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isEnd(int maxRow, int maxCol) {
        return this.row == maxRow - 1
                && this.col == maxCol - 1;
    }

    public Location next(int maxRow, int maxCol) {
        int nextCol = this.col + 1 == maxCol ? 0 : this.col + 1;
        int nextRow = nextCol == 0 ? this.row + 1 : this.row;
        if (nextRow == maxRow) {
            throw new IllegalStateException();
        }
        return new Location(nextRow, nextCol);
    }
}
/*
설계

8*8이면 부르트포스가 가능한가? (2초)

64 * 63 * 62? -> 가능할 것 같기도 함

파라메트릭서치 가능? -> 힘들 것 같음

# 부르트포스 :


 */