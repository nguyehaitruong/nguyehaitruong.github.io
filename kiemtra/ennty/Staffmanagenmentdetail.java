package ennty;

public class Staffmanagenmentdetail {
    private Goods goods;
    private int ordernumber;
    public Staffmanagenmentdetail(Goods goods,int ordernumber){
        this.goods=goods;
        this.ordernumber=ordernumber;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    @Override
    public String toString() {
        return "Staffmanagenmentdetail{" +
                "goods=" + goods +
                ", ordernumber=" + ordernumber +
                '}';
    }
}
