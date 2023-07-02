package logichandle;

import java.util.Scanner;

public class Menu {
    private final Factorylogic factorylogic=new Factorylogic();
    private final Timesheetslogic timesheetslogic=new Timesheetslogic();
    private final Workerlogic workerlogic=new Workerlogic();
    public void menu() {

        while (true) {
            showMenuContent();
            int choice = functionChoice();
            switch (choice) {
                case 1:
                    Workerlogic.inputNewWorker();
                    break;
                case 2:
                    Workerlogic.showWorker();
                    break;
                case 3:
                    Factorylogic.inputNewFactory();
                    break;
                case 4:
                    Factorylogic.showFactory();
                    break;
                case 5:
                    Timesheetslogic. inputNewtimesheets();
                    break;
                case 6:
                    Timesheetslogic.();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    return;
            }
        }
    }

    private int functionChoice() {
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 9) {
                break;
            }
            System.out.println("Nhập sai, mời nhập lại: ");
        } while (true);
        return choice;
    }

    private void showMenuContent() {
        System.out.println("=============PHẦN MỀM QUẢN LÝ BẢNG LƯƠNG CÔNG NHÂN==============");
        System.out.println("1. Thêm mới công nhân.");
        System.out.println("2. In danh sách công nhân.");
        System.out.println("3. Thêm xưởng.");
        System.out.println("4. In danh sách xưởng.");
        System.out.println("5. Lập bảng chấm công.");
        System.out.println("6. In bảng chấm công");
        System.out.println("7. Sắp xếp bảng .");
        System.out.println("8. Tính lương .");
        System.out.println("9. Thoát.");
        System.out.println("Chọn : ");
    }
}
