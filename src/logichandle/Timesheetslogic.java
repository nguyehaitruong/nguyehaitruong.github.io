package logichandle;

import entity.Factory;
import entity.Timesheets;
import entity.Timesheetsdetail;
import entity.Worker;

import java.util.Scanner;

public class Timesheetslogic {



    private Timesheets[]timesheets1=new Timesheets[100];
    private Factorylogic factorylogic;
    private Workerlogic workerlogic;
    public Timesheetslogic(){
        this.factorylogic=factorylogic;
        this.workerlogic=workerlogic;



    }
    public  void inputNewtimesheets() {
        if (!workerlogic.workerIsNotEmpty() || !factorylogic.factoryIsNotEmpty()) {
            System.out.println("Không có dữ liệu về công nhân hoặc xưởng, vui lòng tạo đủ dữ liệu trước khi phân công");
            return;
        }

        System.out.println("Nhập số công nhân: ");
        int workerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < workerNumber; i++) {
            System.out.println("Nhập thông tin cho công nhân thứ " + (i + 1) );
            System.out.println("Nhập ID : ");
            int workerId;
            Worker worker = null;
            do {
                workerId = new Scanner(System.in).nextInt();
                for (int j = 0; j < workerlogic.getWorkers().length; j++) {
                    if (workerlogic.getWorkers()[j] != null && workerlogic.getWorkers()[j].getId() == workerId) {
                        worker = workerlogic.getWorkers()[j];
                        break;
                    }
                }
                if (worker != null) {
                    break;
                }
                System.out.println("Không tồn tại ID xin vui lòng nhập lại: ");
            } while (true);

            System.out.println("làm bao nhiêu xưởng ");
            int factoryNumber = new Scanner(System.in).nextInt();
            Timesheetsdetail[] details = new Timesheetsdetail[factoryNumber];
            int count = 0;
            for (int j = 0; j < factoryNumber; j++) {
                System.out.println("Môn xưởng thứ " + (j + 1));
                int factoryId;
                Factory factory = null;
                do {
                    factoryId = new Scanner(System.in).nextInt();
                    for (int k = 0; k < factorylogic.getFactorys().length; k++) {
                        if (factorylogic.getFactorys()[k] != null && factorylogic.getFactorys()[k].getId() == factoryId) {
                            factory = factorylogic.getFactorys()[k];
                            break;
                        }
                    }
                    if (factory != null) {
                        break;
                    }
                    System.out.println("Không tồn tại xưởng có ID vừa nhập, vui lòng nhập lại: ");
                } while (true);

                System.out.println("xưởng làm mấy hoom ");
                int factoryNum;
                do {
                    factoryNum = new Scanner(System.in).nextInt();
                    if (factoryNum < 1 || factoryNum > 30) {
                        System.out.println("Số lớp phải là số dương và nhỏ hơn 30");
                        continue;
                    }
                    break;
                } while (true);
                Timesheetsdetail timesheetsdetail = new Timesheetsdetail(factory, factoryNumber);
                details[count] = timesheetsdetail;
                count++;
            }

            Timesheets timesheets = new Timesheets(worker, details);
            saveWorker(timesheets);
        }

    }
    public void saveWorker(Timesheets timesheets) {
        for (int i = 0; i < timesheets1.length; i++) {
            if (timesheets1[i] == null) {
                timesheets1[i] = timesheets;
                break;
            }
        }
    }


}
