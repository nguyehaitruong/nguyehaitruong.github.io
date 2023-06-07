package org.example;

import java.util.Scanner;

public class timgiong {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String giongnhau =sc.nextLine();
        String[] array1 = {"Python", "JAVA", "PHP", "C#", "C++", "SQL"};
        String[] array2 = {"MySQL", "SQL", "SQLite", "Oracle", "PostgreSQL", "DB2", "JAVA"};
        for (int i = 0; i<6; i++){
            for (int j=0;j<7;j++){
                if (array1[i].equals(array2[j])){
                    giongnhau+=array1[i];

                }
            }
        }
        System.out.println(""+giongnhau);


    }
}
