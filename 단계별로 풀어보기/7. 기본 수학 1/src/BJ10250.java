import java.util.*;
class BJ10250{
    //한번에 입력했을때 엔터가 부족함
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 0; i<test; i++){
            int height = sc.nextInt();
            int width = sc.nextInt();
            int customer = sc.nextInt();
            int RoomIndex;

            int RoomFloor = customer%height;
            RoomIndex = customer/height;
            if(customer%height == 0){
                RoomIndex--;
                RoomFloor = height;
            }
            System.out.printf("%d", RoomFloor);
            if(RoomIndex < 10)
                System.out.printf("0");
            System.out.printf("%d\n", RoomIndex+1);

        }
    }
}