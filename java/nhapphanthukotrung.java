package org.example;

import java.util.Scanner;

public class nhapphanthukotrung {
    public static int[] nhapchuoi(int n){
        Scanner sc=new Scanner(System.in);

        int a[]=new int[100];
        int dung=0;
        for (int i = 0; i <n;i++) {
            System.out.println("nhap gia trị " + i);
            a[i] = sc.nextInt();
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] == a[j]) {

                    System.out.println("Phần tử đã tồn tại. Mới nhập lại!");

                    break;
                }


            }
        }
        for (int i=0;i<n;i++){
             System.out.println(a[i]);
            }



        return a;

    }

    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap gia tri cua n");
        n= sc.nextInt();

        System.out.println(nhapchuoi(n));


    }


}
