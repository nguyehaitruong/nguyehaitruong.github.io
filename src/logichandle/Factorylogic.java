package logichandle;

import entity.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factorylogic {



    private List<Factory>factorys=new ArrayList<>();

    public List<Factory> getFactorys() {
        return factorys;
    }

    public static void showFactory() {
        System.out.println();
    }

    public static void inputNewFactory() {
        System.out.println("Bạn muốn nhập dữ liệu cho bao nhiêu xưởng: ");
        int factoryNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < factoryNumber; i++) {
            Factory factory = new Factory();
            factory.inputinfo();
            saveFactory(factory);
        }
    }

    public static void saveFactory(Factory factory) {


    }

    public boolean factoryIsNotEmpty() {
        for (int i = 0; i < factorys.length; i++) {
            if (factorys[i] != null) {
                return true;
            }
        }
        return false;
    }
}
