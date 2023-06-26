public class customermanagementdetail {
    private service ser;
    private  int numberservice;
    public customermanagementdetail(service ser,int numberservice){
        this.numberservice=numberservice;
        this.ser=ser;

    }
    public service getSer(){
        return ser;
    }
    public int getNumberservice(){
        return numberservice;
    }

    public void setSer(service ser) {
        this.ser = ser;
    }

    public void setNumberservice(int numberservice) {
        this.numberservice = numberservice;
    }

    @Override
    public String toString() {
        return "customermanagementdetail{" +
                "ser=" + ser +
                ", numberservice=" + numberservice +
                '}';
    }
}
