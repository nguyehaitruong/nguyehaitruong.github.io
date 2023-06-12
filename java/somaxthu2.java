package org.example;

import java.util.Scanner;

public class somaxthu2 {
    public static int max2(int n) {
        Scanner sc = new Scanner(System.in);
        int max = 0, maxsecond = 0, thutu=0,i;
        int so[] = new int[100];
        for ( i = 0; i < n; i++) {
            System.out.println("nhập số" + i);
            so[i] = sc.nextInt();
        }
        for ( i = 0; i < n; i++) {
            if (max < so[i]) {
                maxsecond = max;
                max = so[i];

            }
        }


        return maxsecond;
    }

    public static void main(String[] args) {
        int n,i = 0;
        System.out.println("nhap n");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        System.out.println("so lon thu 2 la"+max2(n));
    }

}
