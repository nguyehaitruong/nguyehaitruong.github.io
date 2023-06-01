package org.example;

import java.util.Scanner;

public class chuvi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap chieu dai");
        int a=sc.nextInt();
        System.out.println("nhap chieu rong");
        int b=sc.nextInt();
        int p,s;
        p=2*(a+b);
        s=a*b;
        System.out.println("chu vi ="+p);
        System.out.println("dien tich="+s);


    }
}
