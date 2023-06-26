package logic;
import ennty.Staff;
import ennty.Staffmanagenment;

import java.util.Scanner;


public class Logicsell {
    private final Staffmanagenment[]staffmanagenments=new Staffmanagenment[100];
    private Logicgoods logicgoods;
    private Logicstaff logicstaff;
    public Logicsell(Logicgoods logicgoods, Logicstaff logicstaff){
        this.logicgoods=logicgoods;
        this.logicstaff=logicstaff;

    }
    public void logicsell()
    {

        System.out.println("nhập số nhân viên bạn muốn tạo bảng");
         int number = new Scanner(System.in).nextInt();
         for (int i=0;i<number;i++){
             System.out.println("nhập id nhân viên");
             int idstaff;
             Staff staff=null;
             do {
                 idstaff=new Scanner(System.in).nextInt();
                 for (int j=0;j<10000;j++){
                     if (!=null&&){



                     }
                 }

             }while (true);
         }


    }


}
