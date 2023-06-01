package org.example;

import java.util.Scanner;

public class pt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("pt co dang ax+b=0");
        System.out.println("nhập a");
        double a=sc.nextInt();
        System.out.println("nhập b");
        double b=sc.nextInt();


       if(a==0){
           System.out.println("x="+(-b));
       }
       else {  double x=(-a)/b;
           System.out.println("x="+x);
       }

    }
}
