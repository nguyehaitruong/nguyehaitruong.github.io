import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class tinhtuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ngày tháng năm sinh (theo định dạng yyyy-MM-dd): ");
        String input = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(input);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        int years = age.getYears();
        System.out.println("Tuổi của người đó là: " + years + " tuổi.");
    }
}
