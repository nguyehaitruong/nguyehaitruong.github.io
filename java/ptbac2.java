import java.util.Scanner;

public class ptbac2 {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
           double a;
            do {
                System.out.print("Nhập lai  hệ số a: ");
                 a = sc.nextDouble();
            }

            while (a == 0);

                System.out.print("Nhập hệ số b: ");
                double b = sc.nextDouble();

                System.out.print("Nhập hệ số c: ");
                double c = sc.nextDouble();

                double delta = b * b - 4 * a * c;

                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("Phương trình có hai nghiệm phân biệt:");
                    System.out.println("x1 = " + x1);
                    System.out.println("x2 = " + x2);
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    System.out.println("Phương trình có nghiệm kép:");
                    System.out.println("x = " + x);
                } else {
                    System.out.println("Phương trình vô nghiệm.");
                }
            }


        }