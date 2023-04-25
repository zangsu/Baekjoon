import java.util.*;

public class Main {
    public static void main(String[] args) {
        int number  = 1;
        GeneralParameter g = new GeneralParameter();
        g.incNum(number);

        Map<Integer, String> map = new HashMap<>();
        CollectionParameter c = new CollectionParameter();
        c.addValue(map);

        System.out.println(number);
        System.out.println(map.isEmpty());

    }
}

