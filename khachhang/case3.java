//import java.util.Scanner;
//
//
//public class case3 {
//
//    private final customermanagement[] customermanagements = new customermanagement[100];
//
//    private logiccustommer logiccustommer;
//    private logicservice logicservice;
//
//    public case3(logiccustommer logiccustommer, logicservice logicservice) {
//        this.logiccustommer=logiccustommer;
//        this.logicservice = logicservice;
//    }
//
//    public void inputNewTeaching() {
//
//
//        System.out.println("Nhập số số khách hàng: ");
//        int customersNumber = new Scanner(System.in).nextInt();
//        for (int i = 0; i < customersNumber; i++) {
//            System.out.println("Nhập thông tin cho khachs hàng " + (i + 1) );
//            System.out.println("Nhập ID : ");
//            int customersId;
//            customers cus = null;
//            do {
//                customersId = new Scanner(System.in).nextInt();
//
//                System.out.println("nhập số dịch vụ: ");
//                int classNumber;
//                do {
//                    classNumber = new Scanner(System.in).nextInt();
//                    if (classNumber < 1 || classNumber > 5) {
//                        System.out.println("Số lớp phải là số dương và nhỏ hơn 5");
//                        continue;
//                    }
//                    break;
//                    while (true);
//
//
//
//                }}}}