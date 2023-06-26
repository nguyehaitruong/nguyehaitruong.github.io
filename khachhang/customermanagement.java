import java.util.Arrays;


public class customermanagement {
    private customers cus;
    private customermanagementdetail[]detail;

    public customermanagement(customers cus, customermanagementdetail[] detail) {
        this.cus=cus;
        this.detail=detail;
    }
    public customers getCus(){
        return cus;
    }
    public void setCus(customers cus){
        this.cus=cus;
    }
    public customermanagementdetail[] getDetail(){
        return detail;
    }

    public void setDetail(customermanagementdetail[] detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "customermanagement{" +
                "cus=" + cus +
                ", detail=" + Arrays.toString(detail) +
                '}';
    }
}
