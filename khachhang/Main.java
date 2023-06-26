import java.util.Scanner;

public class Main {
    private static logicservice logicservice=new logicservice();
    private static logiccustommer logiccustommer=new logiccustommer();

    private static customers[] cs=new customers[100];
    private static service[] sv=new service[100];

    public static void main(String[] args) {

        while (true) {
            System.out.println("============QUAN LY ===========");
            System.out.println("1 nhâp và in ra danh sách khách hàng");
            System.out.println("2 nhập và in ra danh sách dịch vụ");
            System.out.println("3 lập hoá đơn");
            System.out.println("4 in bảng kê khai");
            System.out.println("5 sắp xếp theo họ tên");
            System.out.println("6 sắp xếp theo số lượng");
            System.out.println("7 thống kê thu nhập");
            System.out.println("chọn");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    logiccustommer.cust();
                    break;
                case 2:
                    logicservice.serv();
                case 3:

            }


        }}}