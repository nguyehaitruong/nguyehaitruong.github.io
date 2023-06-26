public class service {
    private String nameservice;
    private int unit;
    private int rates;
    private static int AUTO_ID = 100;
    private  int id;
    public service() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public String getNameservice() {
        return nameservice;
    }

    public void setNameservice(String nameservice) {
        this.nameservice = nameservice;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getRates() {
        return rates;
    }

    public void setRates(int rates) {
        this.rates = rates;
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
        return "service{" +
                "nameservice='" + nameservice + '\'' +
                ", unit=" + unit +
                ", rates=" + rates +
                ", id=" + id +
                '}';
    }
}
