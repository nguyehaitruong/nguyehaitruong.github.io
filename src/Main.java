import java.util.Scanner;


public class Main {
    private static reporter[] rp=new reporter[100];
    private static post[] pos=new post[100];


    public static void main(String[] args) {

      while (true){  System.out.println("============QUAN LY NHUAN BUT CHO PHONG VIEN===========");
          System.out.println("1 nhâp và in ra danh sách phóng viên");
          System.out.println("2 nhập và in ra danh sách kiểu bài viết");
          System.out.println("3 lập bảng tính cho giáo viên");
          System.out.println("4 in bảng kê khai");
          System.out.println("5 sắp xếp theo họ tên");
          System.out.println("6 sắp xếp theo số lượng bài viêt");
          System.out.println("7 thống kê thu nhập");
          System.out.println("chọn");
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          int demrp=0,dempos=0;
          switch (n){
              case 1:
                  System.out.println("nhập số lượng phóng viện");
                  int numberpv=sc.nextInt();
                  for (int i=0;i<numberpv;i++){
                      System.out.println("nhập thông tin  pv"+i+1);
                      reporter rp=new reporter();
                      System.out.println("nhập tên");
                      rp.setName(new Scanner(System.in).nextLine());
                      System.out.println("nhập địa chỉ");
                      rp.setAddress(new Scanner(System.in).nextLine());
                      System.out.println("nhập sdt");
                      rp.setPhone(new Scanner(System.in).nextLine());
                      System.out.println("loại pv");
                      System.out.println("1 chuyen nghiep");
                      System.out.println("2  nghiệp dư");
                      System.out.println("3 CTV");
                      int leverchoise = new Scanner(System.in).nextInt();
                      switch (leverchoise) {
                          case 1:
                              rp.setLevel(type.chuyennghiep);
                          case 2:
                              rp.setLevel(type.nghiepdu);
                          case 3:
                              rp.setLevel(type.CTV);
                      }
                      System.out.println("thôgn tin pv"+i);
                      System.out.println(rp.getAutoId());
                      System.out.println(rp.getName());
                      System.out.println(rp.getAddress());
                      System.out.println(rp.getPhone());
                      System.out.println(rp.getLevtel()); }
                  int dai= rp.length;
                  for (int j=0;j< dai;j++){
                      if (rp[j]==null)
                          demrp=j;

                  }
                  break;

              case 2:
                  System.out.println("nhập số lượng bài viết");
                  int numberpost=sc.nextInt();
                  for (int i=0;i<numberpost;i++){
                      System.out.println("thông tin bài viết "+i);
                      post pos =new post();
                      System.out.println("nhập tên");
                      pos.setName(new Scanner(System.in).nextLine());
                      System.out.println("nhập đơn giá");
                      pos.setDongia(new Scanner(System.in).nextLine());
                      System.out.println("thôgn tin bài"+i);
                      System.out.println(pos.getId());
                      System.out.println(pos.getName());
                      System.out.println(pos.getDongia());}
                  int dai1= pos.length;
                  for (int j=0;j< dai1;j++){
                      if (pos[j]==null)
                          dempos=j;

                  }
                  break;
              case 3:
                  System.out.println("nhập phóng viên ");
                  for (int i=0;i<demrp;i++) {
                      System.out.println("nhaapj nhân viên in bản  lương thứ " + i);
                      int rpid = new Scanner(System.in).nextInt();
                      System.out.println("so bai viet da viet");
                      int bai = sc.nextInt();
                      for (int j = 0; j < bai; j++) {
                          System.out.println("nhập id bài");
                          int idbai = sc.nextInt();
                          post pos = null;
                          int dem3 = 0;
                          if (pos.getId() == idbai) {
                              System.out.println("nhập số lần bài này xuất hiện");
                              dem3 = sc.nextInt();
                              System.out.println("bài " + pos.getId() + "xuất hiện " + dem3 + "lần2");


                          }


                      }
                      break;


                  }
              case 9:
          return;
          }}}}






















