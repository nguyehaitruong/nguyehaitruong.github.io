import lombok.Data;

@Data
public class Sach {
    public static int maSachCount = 10000;
    public int maSach;
    public String tenSach;
    public String tacGia;
    public String chuyenNganh;
    public int namXuatBan;

    public Sach(String tenSach, String tacGia, String chuyenNganh, int namXuatBan) {
        this.maSach = maSachCount++;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXuatBan = namXuatBan;
    }

    // Các phương thức getter, setter và toString đã tự động được tạo bởi Lombok
}
