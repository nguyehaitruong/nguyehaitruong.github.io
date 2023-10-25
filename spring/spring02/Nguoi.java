import lombok.Data;

@Data
public class Nguoi {
    protected String hoTen;
    protected String diaChi;
    protected String soDienThoai;

    public Nguoi(String hoTen, String diaChi, String soDienThoai, String loaiBanDoc) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = String.valueOf(soDienThoai);
    }

}
