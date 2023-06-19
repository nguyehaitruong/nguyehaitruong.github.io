package org.example;

import java.util.Scanner;

public class ql {

    public static void main(String[] args) {
        System.out.println("=============quản lý lương giảng viên===============");
        System.out.println("1 thêm mới giẳng viên");
        System.out.println("2 in danh sách giảng viên ");
        System.out.println("3 thêm mới môn học");
        System.out.println("4 in danh sách môn học ");
        System.out.println("5 lập bẳng kê khai giảng dạy ");
        System.out.println("6 in bảng kê khai");
        System.out.println("7 sắp xếp bảng kê khai ");
        System.out.println("8 tings lương giảng viên");
        System.out.println("9 thoát");
        System.out.println("chọn ");
        int chon = new Scanner(System.in).nextInt();
        switch (chon) {
            case 1:
                System.out.println("nhập số lượng giảng viên");
                int number = new Scanner(System.in).nextInt();
                for (int i = 1; i <= number; i++) {
                    System.out.println("nhâp thông tin giảng viên thứ " + i);
                    giangvien gv = new giangvien();
                    System.out.println("nhập tên");
                    gv.setName(new Scanner(System.in).nextLine());
                    System.out.println("nhập địa chỉ");
                    gv.setAddress(new Scanner(System.in).nextLine());
                    System.out.println("nhập sdt");
                    gv.setPhonenumber(new Scanner(System.in).nextLine());
                    System.out.println("trình độ");
                    System.out.println("1 GS TS");
                    System.out.println("2PGS");
                    System.out.println("3 giảng viên chính");
                    System.out.println("4 thạc sĩ");
                    int leverchoise = new Scanner(System.in).nextInt();
                    System.out.println();
                    gv.setName(new Scanner(System.in).nextLine());
                    switch (leverchoise) {
                        case 1:
                            gv.getLevel(trinhdogv.gstiensi);
                    }

                }
                break;
            case 2:
            case 3:
                System.out.println("nhập số lượng môn");
                int numbersach = new Scanner(System.in).nextInt();
                for (int i = 1; i <= numbersach; i++) {
                    System.out.println("nhâp thông tin môn  " + i);
                    sach sach = new sach();
                    System.out.println("nhap tên sách");
                    sach.setTensach(new Scanner(System.in).nextLine());
                    System.out.println("nhập sô tiết");
                    sach.setTongsotiet(new Scanner(System.in).nextInt());
                    System.out.println("nhập sô tiết ly thuyet");
                    sach.setSotietlythuet(new Scanner(System.in).nextInt());
                    System.out.println("nhập kinh phí");
                    sach.setKinhphi(new Scanner(System.in).nextInt());


                }
        }
    }}
