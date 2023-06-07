package org.example;

public class tb {
    public static void main(String[] args) {
        int numbers[] = new int[]{20, 30, 25, 35, -16, 60, -100};
        double tong=0;
        for (int i=0;i<numbers.length;i++){
            tong+=numbers[i];

        }
        int n=numbers.length;
        double Tong=tong/n;
        System.out.println(""+Tong);
    }
}
