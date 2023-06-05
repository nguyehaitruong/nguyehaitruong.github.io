package org.example;

import java.util.Scanner;


public class demchu {
    public static void main(String[] args) {
        String str = "Hello world";
        System.out.println("Chuỗi là: "+ str);
        DemKyTu(str);


    }

    static void DemKyTu(String str)
    {
        int counter[] = new int[256];
        int len = str.length();
        int max=0;
        int a=0;
        for (int i = 0; i < len; i++){
            counter[str.charAt(i)]++;
            if (counter[str.charAt(i)]>max){
                max=counter[str.charAt(i)];
                a=i;



            }

            }


        char array[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            array[i] = str.charAt(i);
            int flag = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == array[j])
                    flag++;
            }
            if (flag == 1)
                System.out.println("Số lần xuất hiện của " + str.charAt(a)
                        + " trong chuỗi:" + max);
        }
}}
