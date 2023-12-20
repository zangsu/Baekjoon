import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(Fibo.convert(sc.nextLong()));
        //Fibo.called.keySet().stream()
        //      .sorted()
        //    .forEach(key -> System.out.println(key + " " + Fibo.called.get(key)));
    }
}

class Fibo {
    public static final int mod = 1_000_000_007;
    public static final Map<Long, Long> CACHED_FIBO_MAP = new HashMap<>();
    public static final Map<Long, Integer> called = new java.util.HashMap<>();

    static {
        CACHED_FIBO_MAP.put(0L, 0L);
        CACHED_FIBO_MAP.put(1L, 1L);
        CACHED_FIBO_MAP.put(2L, 1L);
        CACHED_FIBO_MAP.put(3L, 2L);
        CACHED_FIBO_MAP.put(4L, 3L);
        CACHED_FIBO_MAP.put(5L, 5L);
        CACHED_FIBO_MAP.put(6L, 8L);
        CACHED_FIBO_MAP.put(7L, 13L);
        CACHED_FIBO_MAP.put(8L, 21L);
        CACHED_FIBO_MAP.put(9L, 34L);
        CACHED_FIBO_MAP.put(10L, 55L);
        CACHED_FIBO_MAP.put(11L, 89L);
        CACHED_FIBO_MAP.put(12L, 144L);
        CACHED_FIBO_MAP.put(13L, 233L);
        CACHED_FIBO_MAP.put(14L, 377L);
        CACHED_FIBO_MAP.put(15L, 610L);
        CACHED_FIBO_MAP.put(16L, 987L);
        CACHED_FIBO_MAP.put(17L, 1597L);
    }

    public static long convert(long index) {
        if (CACHED_FIBO_MAP.containsKey(index)) {
            return CACHED_FIBO_MAP.get(index);
        }

        //called.put(index, called.getOrDefault(index, 0) + 1);
        if (index % 2 == 0) {
            long convertN_2 = convert(index / 2);
            long convertN_2_1 = convert(index / 2 - 1);

            long result = ((convertN_2 * convertN_2) % mod + (2 * convertN_2 * convertN_2_1) % mod) % mod;
            CACHED_FIBO_MAP.put(index, result);
            return result;
        } else {
            long convertN_2 = convert(index / 2);
            long convertN_2_1 = convert(index / 2 + 1);
            long result = ((convertN_2 * convertN_2) % mod + (convertN_2_1 * convertN_2_1) % mod) % mod;
            CACHED_FIBO_MAP.put(index, result);
            return result;
        }
    }
}