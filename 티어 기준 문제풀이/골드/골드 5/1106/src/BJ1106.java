import java.util.*;

public class BJ1106 {
    //12:35 ~ 12:50 & //실패
    // 2트 : 18:50 ~

    //1. 가성비 쓰레기 빼기
    //2. DP 업데이트
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Ad> ads = new LinkedList<>();
        int minMoney = Integer.MAX_VALUE;

        int goalCustomer = sc.nextInt();
        int cityNum = sc.nextInt();

        int[] countCase = new int[cityNum];
        for (int city = 0; city < cityNum; city++) {
            int price = sc.nextInt();
            int customer = sc.nextInt();
            ads.add(new Ad(price, customer));
        }

        Collections.sort(ads);
        filterAds(ads);

        for (Ad ad : ads) {
            System.out.println(ad);
        }

        Solver solver = new Solver(cityNum);
        minMoney = solver.calcMinMoney(goalCustomer, ads);

        //DP[n] = 목표가 n명일 때의 최솟값값
       //int[] DP = new int[goalCustomer];



        System.out.println(minMoney);


    }

    static void filterAds(List<Ad> ads){
        for(int i = 0; i<ads.size(); i++){
            Ad pivot = ads.get(i);
            for(int j = 0; j<ads.size(); j++){
                if (pivot.canReplace(ads.get(j))) {
                    ads.remove(j);
                    j--;
                }
            }

        }
    }
}



class Solver{

    int minMoney = Integer.MAX_VALUE;
    int[] countCase;
    List<Ad> ads;

    public Solver(int cityNum) {
        countCase = new int[cityNum];
    }

    public int calcMinMoney(int goalCustomer, List<Ad> ads){
        this.ads = ads;
        checkCase(0, goalCustomer);

        return minMoney;
    }

    public void checkCase(int idx, int modPerson){
        //idx 번째 인덱스의 값을 최대부터 낮춰 가면서 최솟값 탐색색
        if(modPerson < 0){
            countCase[idx] = 0;
            int money = 0;
            for(int i = 0; i<=idx; i++)
                money += ads.get(i).price * countCase[i];
            if(money < minMoney){
                minMoney = money;
            return;
            }
        }

        int count = modPerson / ads.get(idx).customer;
        if(modPerson % ads.get(idx).customer != 0)
            count++;
        countCase[idx] = count;

        if (idx == ads.size() - 1) {
            countCase[idx] = count;
            int money = 0;
            for(int i = 0; i<ads.size(); i++)
                money += ads.get(i).price * countCase[i];
            if(money < minMoney){
                minMoney = money;
            }
            return;
        }

        while(countCase[idx] > 0){
            countCase[idx] = count;
            checkCase(idx+1, modPerson - (ads.get(idx).customer * countCase[idx]));
            count--;
        }


    }
}
class Ad implements Comparable<Ad>{
    int price;
    int customer;
    /*static Comparator<Ad> comparator = new Comparator<Ad>() {
       @Override
       public int compare(Ad ad1, Ad ad2) {
           double ad1Work = (double)ad1.customer / (double)ad1.price;
           double ad2Work = (double)ad2.customer / (double)ad2.price;

           if(ad1Work == ad2Work){
               return ad1.customer - ad2.customer;
           }
           else{
               if(ad1Work > ad2Work)
                   return -1;
               return 1;
           }
       }
   };*/

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass())
            return false;
        return (this.customer == ((Ad) obj).customer) && (this.price == ((Ad)obj).price);
    }

    public Ad(int price, int customer) {
        this.price = price;
        this.customer = customer;
    }

    public String toString(){
        return "Customer : " + this.customer + ", price : " + this.price;
    }


    public boolean canReplace(Ad ad1){
        if(this.equals(ad1))
            return false;
        if(this.customer > ad1.customer && this.price < ad1.price)
            return true;
        int times = ad1.customer / this.customer;
        if(ad1.customer % this.customer != 0)
            times++;
        if(this.price * times <= ad1.price)
            return true;
        return false;
    }


    @Override
    public int compareTo(Ad o) {
        if (this.equals(o))
        return 0;
        double o1Work = (double) ((Ad)this).customer / ((Ad)this).price;
        double o2Work = (double) ((Ad) o).customer / ((Ad) o).price;

        if(o1Work == o2Work)
            return ((Ad) this).customer  - ((Ad) o).customer;
        if(o1Work > o2Work)
            return -1;
        return 1;
    }
}
