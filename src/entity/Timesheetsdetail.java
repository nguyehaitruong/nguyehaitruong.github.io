package entity;

public class Timesheetsdetail {
    private Factory factory;
    private int factorynumber;

    public Timesheetsdetail(Factory factory, int factoryNumber) {

    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public int getFactorynumber() {
        return factorynumber;
    }

    public void setFactorynumber(int factorynumber) {
        this.factorynumber = factorynumber;
    }

    @Override
    public String toString() {
        return "Timesheetsdetail{" +
                "factory=" + factory +
                ", factorynumber=" + factorynumber +
                '}';
    }
}
