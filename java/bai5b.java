package org.example;

import java.util.Scanner;

public class bai5b {
    public static void main(String[] args) {
        System.out.println("nhap chuoi bat ki");
        Scanner sc=new Scanner(System.in);
        String chuoi= sc.nextLine();
        System.out.println("nhap s2");
        String s2= sc.nextLine();
        System.out.println("nhap s3");
        String s3= sc.nextLine();
        System.out.println(chuoi.replace(s2,s3));

    }
}
