
import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        double weight = 0 , height = 0, bmi;

        Scanner banphimScanner = new Scanner(System.in);

        
        try {
            System.out.println("Nhap chieu cao (cm): ");
            height  = banphimScanner.nextDouble();
            height = height / 100;
            System.out.println("Nhap can nang (kg): ");
            weight  = banphimScanner.nextDouble();
            bmi = weight / (height*height);
            System.out.println("Chi so BMI cua ban la: " + bmi);
        } catch (Exception e) {
            System.out.println("Nhap sai, vui long nhap lai");
        }

        bmi = weight / (height*height);
        
        if (bmi < 18.5) {
            System.out.println("Thieu can");

        }
        else if (bmi >=  18.5 && bmi <= 24.9){
            System.out.println("ban co mot co the tot");
        }
        else if (bmi >= 25 && bmi <= 29.9) {
            System.out.println("Thua can");
            
        }
        else if (bmi >= 30) {
            System.out.println("Beo phi");
        }
    }
}

// Constructor là gì ?
// Constructor là một phương thức đặc biệt trong Java, được sử dụng để khởi tạo đối tượng.
// Dùng để làm gì ?
// Constructor được sử dụng để khởi tạo đối tượng. Khi một đối tượng được tạo, ít nhất một constructor sẽ được gọi.
// Còn dùng để làm gì nữa không ?
// Constructor cũng được sử dụng để khởi tạo giá trị mặc định cho đối tượng.
// Gitter và Setter là gì ?

