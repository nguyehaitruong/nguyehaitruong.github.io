package org.example;

import java.util.Scanner;

public class thuannghich {



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap n");
        int n=sc.nextInt();
        int so[] = new int[n];
        int i;
        for ( i=0;i<n;i++){
            System.out.println("nhập số"+i);
            so[i]= sc.nextInt();
        }

        for (i = 0; i <(n)/2; i++) {
            if (so[i]==so[n-i-1]) {
                System.out.println("hàm thuạn nghich");}
            else {
                System.out.println("hàm ko thuan nghich");}


    }}}