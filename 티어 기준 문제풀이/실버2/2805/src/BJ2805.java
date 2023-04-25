import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int goal = Integer.parseInt(input[1]);

        Integer[] trees = new Integer[size];
        String[] treeList = br.readLine().split(" ");
        for (int i = 0; i < size; i++)
            trees[i] = Integer.parseInt(treeList[i]);
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        Arrays.sort(trees, c);


        int pivot = trees[0];


        int sum = 0;
        int currentCheck = 0;
        for(;pivot>0; pivot--){
            for(;currentCheck<trees.length; currentCheck++){
                if(trees[currentCheck] <= pivot)
                    break;
            }
            sum += currentCheck;
            if(sum >= goal)
                break;
        }

        System.out.println(pivot);
    }
}
