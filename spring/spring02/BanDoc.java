import lombok.Data;

@Data
public class BanDoc extends Nguoi {
    private static int maBanDocCount = 10000;
    private int maBanDoc;
    private String loaiBanDoc;

    public BanDoc(String hoTen, String diaChi, String soDienThoai, String loaiBanDoc) {
        super(hoTen, diaChi, soDienThoai, loaiBanDoc);

        this.loaiBanDoc = loaiBanDoc;
    }
    static int tangMaBanDoc(){
        return maBanDocCount++;
    }

}
