package logichandle;

import entity.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Workerlogic {



    private static List<Worker>workers=new ArrayList<>();

    public static List<Worker> getWorkers() {
        return workers;
    }

    public static void inputNewWorker() {
        System.out.println("Bạn muốn thêm mới bao nhiêu công nhân: ");
        int workerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < workerNumber; i++) {
            System.out.println("Nhập thông tin cho công nhân thứ " + (i + 1));
            Worker worker = new Worker();
            worker.inputinfo();

        }
    }

    public static void saveWorker(Worker worker) {
        workers.add(worker);

    }


    public static void showWorker() {
        System.out.println(workers);
    }

    public boolean workerIsNotEmpty() {

        return workers.isEmpty();
}}
