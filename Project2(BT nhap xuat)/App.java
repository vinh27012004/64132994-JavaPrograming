import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int a, b, tong;
        //chuan bi du lieu
        Scanner banphimScanner = new Scanner(System.in); 
        //System.in dai dien cho ban phim
        //System.out dai dien cho chuot
        // Nhap du lieu
        System.out.println("Tinh tong 2 so nguyen");

        System.out.print("A = ");
        // NGUOI DUNG NHAP
        a = banphimScanner.nextInt();

        System.out.print("B = ");

        b = banphimScanner.nextInt();

        tong = a + b;

        
        System.out.println("Tong = " +tong);

    }
}
