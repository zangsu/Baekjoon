import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BJ10866 {
	public static void main(String[] args) throws IOException {
		Deque<Integer> deque = new ArrayDeque<>();
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num;

		for(int i = 0; i<n;	 i++){
			//String line = sc.nextLine();
			String line = br.readLine();
			String op = line.split(" ")[0];
			if(op.equals("push_back")){
				num = Integer.parseInt(line.split(" ")[1]);
				deque.addLast(num);
			}else if(op.equals("push_front")){
				num = Integer.parseInt(line.split(" ")[1]);
				deque.addFirst(num);
			}else if(op.equals("pop_front")){
				if(deque.isEmpty())
					System.out.println(-1);
				else {
					num = deque.pollFirst();
					System.out.println(num);
				}
			}else if(op.equals("pop_back")){
				if(deque.isEmpty())
					System.out.println(-1);
				else {
					num = deque.pollLast();
					System.out.println(num);
				}
			}else if(op.equals("size")){
				System.out.println(deque.size());
			}else if(op.equals("empty")){
				if(deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if (op.equals("front")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekFirst());
			}else if (op.equals("back")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekLast());
			}
		}
	}
}
