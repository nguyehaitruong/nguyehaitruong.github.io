package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class chen {
    public static void main(String[] args) {




    int[] myArray = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
    int valueToInsert = 5;
    int insertIndex = 2;

    int[] newArray = new int[myArray.length + 1];

        for (int i = 0, j = 0; i < newArray.length; i++, j++) {
        if (i == insertIndex) {
            newArray[i] = valueToInsert;
            j--;
        } else {
            newArray[i] = myArray[j];
        }
    }

        System.out.println("chuoi: " + Arrays.toString(myArray));
        System.out.println("chuoi moi: " + Arrays.toString(newArray));

    }
}








