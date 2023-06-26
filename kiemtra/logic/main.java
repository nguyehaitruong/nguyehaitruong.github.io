package logic;

import java.util.Scanner;

public class main {
    private static Logicstaff logicstaff=new Logicstaff();
    private static Logicgoods logicgoods=new Logicgoods();
    private static Logicsell loigcsell=new Logicsell();



        public static void main(String[] args) {

            while (true) {
                System.out.println("============QUAN LY ===========");
                System.out.println("1 nhâp và in ra danh sach nhan vien ban hang");
                System.out.println("2 nhập và in ra danh sách mặt hàng");
                System.out.println("3 lập bảng danh sách bán");
                System.out.println("4 in bảng danh sách bán");
                System.out.println("5 sắp xếp theo họ tên");
                System.out.println("6 sắp xếp theo nôms mắt hàng");
                System.out.println("7 thống kê thu nhập");
                System.out.println("chọn");
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();

                switch (n) {
                    case 1:
                        logicstaff.nv();

                        break;
                    case 2:
                        logicgoods.hang();
                        break;

                    case 3:
                        loigcsell.logicsell();
                        break;



                }


            }}

    }

