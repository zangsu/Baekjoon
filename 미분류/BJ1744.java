import java.util.*;

public class BJ1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> pos = new ArrayList<Integer>();
        int one = 0,  zero= 0;
        ArrayList<Integer> neg = new ArrayList<Integer>();

        int num = sc.nextInt();
        for(int i = 0; i<num; i++){
            int number = sc.nextInt();
            if(number == 1)
                one++;
            else if(number == 0)
                zero = 1;
            else if(number > 1)
                pos.add(number);
            else if(number < 0)
                neg.add(number);
        }
        sc.close();
        Collections.sort(pos);
        Collections.sort(neg, Collections.reverseOrder());

        for(int i = 0; i<pos.size(); i+= 2){
            if(i+1 < pos.size())
                one = one + (pos.get(i) * pos.get(i+1) );
            else
                one += pos.get(i);
        }
        for(int i = 0; i<neg.size(); i+=2)
        {
            if(i+1 < neg.size())
                one = one + (neg.get(i) * neg.get(i+1) );
            else
                if(zero== 0)
                    one += neg.get(i);
        }

        System.out.print(one);
    }
}
//왜 틀렸다고 뜨는지 몰겠음