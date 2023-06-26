package ennty;

public class Goods {
    private String tenmathang;

    private int giaban;
    private int soluong;

    public Goods getChoise() {
        return choise;
    }

    public void setChoise(Goods choise) {
        this.choise = choise;
    }

    private Goods choise;
    private static int ID = 10000;
    private  int id;
    public Goods() {
        this.id = ID;
        ID++;
    }



    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Goods.ID = ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmathang() {
        return tenmathang;
    }

    public void setTenmathang(String tenmathang) {
        this.tenmathang = tenmathang;
    }




    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "mathang{" +
                "tenmathang='" + tenmathang + '\'' +

                ", giaban=" + giaban +
                ", soluong=" + soluong +
                ", level=" + choise +
                ", id=" + id +
                '}';
    }

    public void setChoise(Product product) {

    }
}
