package entity;

import java.util.Scanner;

public class Factory implements inputinfo{
    private String namefac;
    private String describe;
    private int coefficient;
    private int id;
    private static int AUTO_ID = 100;

    public String getNamefac() {
        return namefac;
    }

    public void setNamefac(String namefac) {
        this.namefac = namefac;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "namefac='" + namefac + '\'' +
                ", describe='" + describe + '\'' +
                ", coefficient=" + coefficient +
                ", id=" + id +
                '}';
    }


    @Override
    public void inputinfo() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên xươởng: ");
        this.namefac = new Scanner(System.in).nextLine();
        System.out.println("Nhập mô tả: ");
        this.describe = new Scanner(System.in).nextLine();
        System.out.println("Nhập hệ số công việc: ");
        this.coefficient = new Scanner(System.in).nextInt();

    }


}

