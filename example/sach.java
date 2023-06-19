package org.example;

public class sach {
    private String tensach;
    private int tongsotiet;
    private int sotietlythuet;
    private int kinhphi;

    public static int mamon=100;

    public String getTensach(String s) {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getTongsotiet() {
        return tongsotiet;
    }

    public void setTongsotiet(int tongsotiet) {
        this.tongsotiet = tongsotiet;
    }

    public int getSotietlythuet() {
        return sotietlythuet;
    }

    public void setSotietlythuet(int sotietlythuet) {
        this.sotietlythuet = sotietlythuet;
    }

    public int getKinhphi() {
        return kinhphi;
    }

    public void setKinhphi(int kinhphi) {
        this.kinhphi = kinhphi;
    }

    @Override
    public String toString() {
        return "sach{" +
                "tensach='" + tensach + '\'' +
                ", tongsotiet=" + tongsotiet +
                ", sotietlythuet=" + sotietlythuet +
                ", kinhphi=" + kinhphi +
                '}';
    }
}
