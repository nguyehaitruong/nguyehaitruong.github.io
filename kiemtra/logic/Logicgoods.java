package logic;

import java.util.Scanner;
import ennty.Goods;
import ennty.Product;

public class Logicgoods {
    public void hang(){
        Scanner sc=new Scanner(System.in);

        System.out.println("nập số lượng sản phầm");
        int ssp=sc.nextInt();
        for (int i=0;i<ssp;i++){
            System.out.println("nhập thông tin nhận viên thứ "+i);
            System.out.println("nhập tên sản phẩm"+i);
            Goods sp =new Goods();
            System.out.println("nhập tên sp");
            sp.setTenmathang(new Scanner(System.in).nextLine());
            System.out.println("nhập giá bán ");
            sp.setTenmathang(new Scanner(System.in).nextLine());
            System.out.println("nhập số lượng");
            sp.setTenmathang(new Scanner(System.in).nextLine());
            System.out.println("sản phẩm");
            System.out.println();
            System.out.println();
            System.out.println();
            int choise = new Scanner(System.in).nextInt();
            switch (choise) {
                case 1:
                    sp.setChoise(Product.dientu);

                case 2:
                    sp.setChoise(Product.maytinh);


                case 3:
                    sp.setChoise(Product.diẹnlanh );
                case 4:
                    sp.setChoise(Product.thietbivanphong);
            }

            System.out.println("thông tin sản phẩm"+i);
            System.out.println("tên sản phẩm"+sp.getTenmathang());
            System.out.println("số lượng sản phẩm"+sp.getSoluong());

            System.out.println("giá bán "+sp.getGiaban());
            System.out.println("loiaj thiết bị"+sp.getChoise());

            System.out.println("id nhân viên"+sp.getId());







    }
}}
