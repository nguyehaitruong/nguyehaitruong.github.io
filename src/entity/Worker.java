package entity;

import java.util.Scanner;

public class Worker extends Person {
    private static int AUTO_ID = 1000;

    private int id;
    private int level;

    public Worker() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", level=" + level +
                '}';
    }
    @Override
    public void inputinfo(){
        super.inputinfo();
        System.out.println("nhâpj bậc công nhân yêu cầu lớn hơn 1 và nhỏ hơn 7");
        int level;
        do {
            level = new Scanner(System.in).nextInt();
            if (level >= 1 && level <= 7) {
                break;
            }
            System.out.println("Nhập sai, mời nhập lại: ");
        } while (true);
        this.setLevel(level);

    }
}
