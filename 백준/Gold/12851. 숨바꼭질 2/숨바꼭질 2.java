import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static final int MIN_LOCATION = 0;
    public static final int MAX_LEN = 200_000;
    public static final int NOT_REACHED = 0;
    private static int goal;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        goal = sc.nextInt();
        int[] times = new int[MAX_LEN];
        int[] numbers = new int[MAX_LEN];
        numbers[start] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty() && times[goal] == NOT_REACHED) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = Optional.ofNullable(queue.poll())
                        .orElseThrow(() -> new RuntimeException("queue is empty"));
                List<Integer> nexts = List.of(current - 1, current + 1, current * 2);
                nexts.stream()
                        .filter(next -> next >= MIN_LOCATION && next < MAX_LEN && next != start)
                        .filter(next -> times[next] == NOT_REACHED || times[next] == times[current] + 1)
                        .forEach(next -> {
                            if (times[next] == NOT_REACHED) {
                                queue.add(next);
                            }
                            times[next] = times[current] + 1;
                            numbers[next] += numbers[current];
                        });
            }
        }

        System.out.println(times[goal]);
        System.out.println(numbers[goal]);
    }

}