import java.util.InputMismatchException;
import java.util.Scanner;

public class logiccustommer {
    private customers[]cs=new customers[100];
    public customers[]getCus(){
        return cs;
    }
    public void cust(){
        System.out.println("nhập số lượng phóng viện");
        Scanner sc=new Scanner(System.in);
        int numbersv = 0;
        while (true){
        try {
            numbersv = sc.nextInt();
            if (numbersv>=1)
            break;

        }
        catch (InputMismatchException exception) {
            System.out.println("sai định dạng");
            break;


        }}
        int demcs=0;
        for (int i = 0; i < numbersv; i++) {
            System.out.println("nhập thông tin  pv" + i + 1);
            customers cs = new customers();
            System.out.println("nhập tên");
            cs.setName(new Scanner(System.in).nextLine());
            System.out.println("nhập địa chỉ");
            cs.setAddress(new Scanner(System.in).nextLine());
            System.out.println("nhập sdt");
            cs.setPhone(new Scanner(System.in).nextLine());
            System.out.println("loại pv");
            System.out.println("1 chuyen nghiep");
            System.out.println("2  nghiệp dư");
            System.out.println("3 CTV");
            int leverchoise = new Scanner(System.in).nextInt();
            switch (leverchoise) {
                case 1:
                    cs.setLevel(customer.canhan);
                case 2:
                    cs.setLevel(customer.daidiendoanhnghiep);
                case 3:
                    cs.setLevel(customer.daidienhanhchinh);
            }
            System.out.println("thôgn tin pv" + i);
            System.out.println(cs.getAutoId());
            System.out.println(cs.getName());
            System.out.println(cs.getAddress());
            System.out.println(cs.getPhone());
            System.out.println(cs.getId());
        }
        int dai = cs.length;
        for (int j = 0; j < dai; j++) {
            if (cs[j] == null)
                demcs = j;

        }

    }
}
