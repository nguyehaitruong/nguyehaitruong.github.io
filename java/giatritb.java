package org.example;

import java.util.Scanner;

public class giatritb {
    public static void main(String[] args) {

        int dayso[]=new int[256];
        int max=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap n");
        int n=sc.nextInt();
        for (int i=0;i<n;i++){
            System.out.println("nhap gia trị a"+i);
            dayso[i]= sc.nextInt();

        }
        int min=dayso[0];
        for (int i=0;i<n;i++) {
            if (dayso[i] > max)
                max = dayso[i];
            if (dayso[i] < min)
                min = dayso[i];
        }
        int s=0;
        for (int i=0;i<n;i++){
             s+=dayso[i];
        }
        int tong=(s-max-min)/(n-2);
        System.out.println(""+tong);
        }
}
