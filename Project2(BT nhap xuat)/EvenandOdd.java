
import java.util.Scanner;

public class EvenandOdd {
    public   static void main(String[] args) {
        int a, b, tong;

        Scanner banphimScanner = new Scanner(System.in);

        System.out.print("A = ");
        // NGUOI DUNG NHAP
        a = banphimScanner.nextInt();

        if ((a % 2) != 0) {
            System.out.println("day la so le");

        }else
            System.out.println("day la so chan");
    }
}
