import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyMuonSach qlMuonSach = new QuanLyMuonSach();
        Scanner scr = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.println("--------------------");
            System.out.println("QUẢN LÝ MƯỢN SÁCH");
            System.out.println("1. Nhập danh sách sách mới");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Nhập danh sách bạn đọc mới");
            System.out.println("4. Hiển thị danh sách bạn đọc");
            System.out.println("5. Lập bảng mượn sách");
            System.out.println("6. Hiển thị bảng mượn sách");
            System.out.println("7. Sắp xếp bảng mượn sách theo tên bạn đọc");
            System.out.println("8. Sắp xếp bảng mượn sách theo số lượng sách mượn giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scr.nextInt();
            scr.nextLine(); // Đọc bỏ dòng mới

            switch (choice) {
                case 1 -> qlMuonSach.nhapDanhSachSachMoi();
                case 2 -> qlMuonSach.hienThiDanhSachSach();
                case 3 -> qlMuonSach.nhapDanhSachBanDocMoi();
                case 4 -> qlMuonSach.hienThiDanhSachBanDoc();
                case 5 -> qlMuonSach.lapBangMuonSach();
                case 6 -> qlMuonSach.hienThiBangMuonSach();
                case 7 -> qlMuonSach.sapXepBangMuonSachTheoTenBanDoc();
                case 8 -> qlMuonSach.sapXepBangMuonSachTheoSoLuongSachMuon();
                case 0 -> System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
