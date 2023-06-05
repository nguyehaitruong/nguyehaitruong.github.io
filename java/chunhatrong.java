package org.example;

import java.util.Scanner;

public class chunhatrong { public static void main(String[] args) {
    int hei,wid;
    Scanner sc=new Scanner(System.in);
    System.out.println("nhap chieu dai");
    hei= sc.nextInt();
    System.out.println("nhập chiều rộng");
    wid= sc.nextInt();
    for(int i = 1; i <= wid; i++) {
        for (int j = 1; j <= hei; j++) {
            if(i == 1 || j == hei || j == 1 || i == wid)
                System.out.print("*  ");
            else
                System.out.print("   ");
        }
        System.out.println();
    }

}
}
