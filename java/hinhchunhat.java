package org.example;

import java.util.Scanner;

public class hinhchunhat {
    public static void main(String[] args) {
        int hei,wid;
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap chieu dai");
        hei= sc.nextInt();
        System.out.println("nhập chiều rộng");
        wid= sc.nextInt();
        for(int i = 1; i <= wid; i++) {
            for (int j = 1; j <= hei; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }

    }
}
