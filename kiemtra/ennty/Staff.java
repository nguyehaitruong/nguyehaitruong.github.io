package ennty;

public class Staff extends Person {
    private int ngayki;
    private Staff level;
    private static int AUTO_ID = 1000;
    private  int id;
    public Staff() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getNgayki() {
        return ngayki;
    }

    public void setNgayki(int ngayki) {
        this.ngayki = ngayki;
    }

    public Staff getLevel() {
        return level;
    }

    public void setLevel(Staff level) {
        this.level = level;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "nhanvien{" +
                "ngayki=" + ngayki +
                ", level=" + level +
                ", id=" + id +
                '}';
    }
}
