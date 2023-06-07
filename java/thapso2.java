package org.example;

public class thapso2 {
    public static void main(String[] args) {
        for (int i=1;i<6;i++){
            for (int j=1;j<=i;j++){
                int arr[]=new int [100];
                arr[j]=i;
                System.out.print(arr[j]);
            }
            System.out.println(" ");
        }
    }
}
