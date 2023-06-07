package org.example;

import java.util.Scanner;

public class daoso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number;
        do {
            System.out.print("Nhập một số nguyên dương: ");
            number = scanner.nextInt();
        } while (number <= 0);

        System.out.println("Số ban đầu: " + number);


        int reversedNumber = 0;
        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        System.out.println("Số đã đảo ngược: " + reversedNumber);

    }}
