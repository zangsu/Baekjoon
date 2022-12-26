import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BJ10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> list = new ArrayList<>();
        int num = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i<num; i++){
            list.add(new Customer(i, sc.nextLine()));
        }

        Comparator<Customer> c = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if(o1.age == o2.age){
                    return o1.count - o2.count;
                }
                else{
                    return o1.age - o2.age;
                }
            }
        };

        list.sort(c);

        for (Customer customer : list) {
            System.out.println(customer.age + " " + customer.name);
        }
    }
    static class Customer{
        int count;
        int age;
        String name;
        Customer(int count, String line){
            this.count = count;
            this.age = Integer.parseInt(line.split(" ")[0]);
            this.name = line.split(" ")[1];
        }
    }
}
