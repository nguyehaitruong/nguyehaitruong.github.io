package logic;
import ennty.Staff;

import java.util.Scanner;

public class Logicstaff {
    private Logicstaff[]logicstaffs=new Logicstaff[100];
    public Logicstaff[]getLogicstaffs(){
        return logicstaffs;
    }
    public  void nv() {
    Scanner sc=new Scanner(System.in);
        System.out.println("nập số lượng nhận viên");
        int nv=sc.nextInt();
        for (int i=0;i<nv;i++){
            System.out.println("nhập thông tin nhận viên thứ "+i);
            System.out.println("nhập tên "+i);
            Staff nhanv=new Staff();
            nhanv.setName(new Scanner(System.in).nextLine());
            System.out.println("nhập địa chỉ"+i);
            nhanv.setAddress(new Scanner(System.in).nextLine());
            System.out.println("nhập số điện thoaij"+i);
            nhanv.setAddress(new Scanner(System.in).nextLine());
            System.out.println("nhập ngày ký hợp đồng"+i);
            nhanv.setAddress(new Scanner(System.in).nextLine());
            System.out.println("thông tin nhân viên"+i);
            System.out.println("tên nhân viên"+nhanv.getName());
            System.out.println("đại chỉ  nhân viên"+nhanv.getAddress());

            System.out.println("sdt nhân viên"+nhanv.getPhone());

            System.out.println("id nhân viên"+nhanv.getId());
        }


}}
