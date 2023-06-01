package org.example;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        System.out.println("nhap chuoi bat ki");
        Scanner sc=new Scanner(System.in);
        String chuoi= sc.nextLine();
        System.out.println("nhap ki tu can tim");
        String kitu=sc.nextLine();
        int a= chuoi.indexOf(kitu);
        int b=chuoi.lastIndexOf(kitu);




        System.out.println("ki tu dau la"+a);
        System.out.println("ki tu cuoi la"+b);

    }
}
