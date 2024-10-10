import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 */
public class App {

  public static void main(String[] args) {
    FileOutputStream fout = null;
    try {
      fout = new FileOutputStream("num.txt");
    } catch (FileNotFoundException e) {
      System.out.println("File khong co, xem lai");
    }
    try {
      for(int i=1;i<127;i++) fout.write(i);
      fout.flush();
      fout.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Done");
  }

}