package org.example;

import java.util.Scanner;

public class mangtang1 {
    public static void main(String[] args) {

     int dayso[]=new int[256];
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap n");
        int n=sc.nextInt();
        for (int i=0;i<n;i++){
            System.out.println("nhap gia trị a"+i);
           dayso[i]= sc.nextInt();

        }
        System.out.print("day so :");
        for (int i=0;i<n;i++){
            System.out.print("   "+dayso[i]);
        }
        for (int i=0;i<n;i++){
            if (dayso[i]%2==0){
                dayso[i]=dayso[i]+1;
            }
        }
        System.out.print("day so moi:");
        for (int i=0;i<n;i++){
            System.out.print("   "+dayso[i]);

    }
}}
