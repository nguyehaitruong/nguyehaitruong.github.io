package ennty;

import java.util.Arrays;

public class Staffmanagenment {
    private Staff staff;
    private Staffmanagenmentdetail[] details;
    public Staffmanagenment(Staff staff,Staffmanagenmentdetail[] details){
        this.staff=staff;
        this.details=details;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Staffmanagenmentdetail[] getDetails() {
        return details;
    }

    public void setDetails(Staffmanagenmentdetail[] details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Staffmanagenment{" +
                "staff=" + staff +
                ", details=" + Arrays.toString(details) +
                '}';
    }
}
