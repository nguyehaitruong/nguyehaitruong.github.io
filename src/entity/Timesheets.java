package entity;

import java.util.Arrays;

public class Timesheets {
    private Worker worker;
    private Timesheetsdetail[] details;

    public Timesheets(Worker worker, Timesheetsdetail[] details) {

    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Timesheetsdetail[] getDetails() {
        return details;
    }

    public void setDetails(Timesheetsdetail[] details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Timesheets{" +
                "worker=" + worker +
                ", details=" + Arrays.toString(details) +
                '}';
    }
}
