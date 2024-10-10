import java.io.FileWriter;
import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    FileWriter fw;

    fw = new FileWriter("output.txt");
    fw.write("Song que anh nho em rat nhieu\n");
    fw.write("De anh 9 dai 10 kho thuong em");

    fw.flush();
    fw.close();
  }
}