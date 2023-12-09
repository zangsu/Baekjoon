import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static int numberSize = 0;
    private static int seqSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        numberSize = Integer.parseInt(input[0]);
        seqSize = Integer.parseInt(input[1]);

        List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        findSequence(new ArrayList<>(), numbers, bw);
        bw.flush();
        bw.close();
    }

    private static void findSequence(List<Integer> sequence, List<Integer> numbers, BufferedWriter bw) throws IOException {

        if(sequence.size() == seqSize){
            for (Integer i : sequence) {
                bw.write(i + " ");
            }
            bw.write(System.lineSeparator());
            return;
        }

        Set<Integer> notUsed = new HashSet<>(numbers);

        for(Integer number : numbers){
            if(!notUsed.contains(number)){
                continue;
            }
            notUsed.remove(number);
            sequence.add(number);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(nextNumbers.indexOf(number));
            /*System.out.println("[INFO] number : " + number + ", numberPool : ");
            numbers.forEach(i -> System.out.print(i + " "));
            System.out.println();*/
            findSequence(sequence, nextNumbers, bw);
            sequence.remove(sequence.size() - 1);
        }
    }
}