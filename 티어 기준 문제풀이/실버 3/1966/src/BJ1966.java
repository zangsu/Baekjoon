import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1966 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> print = new LinkedList<>();



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(br.readLine());

        for(int test = 0; test < testNum; test++){

            Printer printer = new Printer();
            int count = 0;

            String[] input = br.readLine().split(" ");
            int docsNum = Integer.parseInt(input[0]);
            int target = Integer.parseInt(input[1]);

            String[] docsList = br.readLine().split(" ");
            for(int i = 0; i<docsNum; i++){
                int docs = Integer.parseInt(docsList[i]);
                if(i == target)
                    printer.addDocs(new Docs(docs, true));
                else
                    printer.addDocs(new Docs(docs, false));
            }

            bw.write(Integer.toString(printer.print()) + '\n');
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

class Printer{
    Queue<Docs> printerQueue;
    HashMap<Integer, Integer> docsList;

    public Printer(){
        printerQueue = new LinkedList<>();
        docsList = new HashMap<>();
        for(int i = 1; i<=9; i++){
            docsList.put(i, 0);
        }
    }

    public void addDocs(Docs docs){
        printerQueue.add(docs);
        docsList.put(docs.prime, docsList.get(docs.prime) + 1);
    }

    public int print(){
        int count = 0;
        while(printerQueue.isEmpty() == false) {
            Docs docs = printerQueue.poll();
            if (isPrintable(docs) == false){
                printerQueue.add(docs);
                continue;
            }
            if(docs.target)
                return count+1;
            docsList.put(docs.prime, docsList.get(docs.prime) - 1);
            count++;
        }

        return 0;
    }

    private boolean isPrintable(Docs docs){
        for(int i = 9; i>docs.prime; i--){
            //System.out.println(i + " " + docsList.get(i) + '\n');
            if(docsList.get(i) != 0)
                return false;
        }
        return true;
    }
}
class Docs{
    int prime;
    boolean target;

    public Docs(int prime, boolean target){
        this.prime = prime;
        this.target = target;
    }
}