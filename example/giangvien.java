package org.example;

public class giangvien extends connguoi {
    public static int ID=100;
    private int id;
    private trinhdogv level;
    public giangvien(){
        this.id=ID;
        ID++;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public void getLevel(trinhdogv gstiensi) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "giangvien{" +
                "id=" + id +
                ", level=" + level +
                '}';
    }
}
