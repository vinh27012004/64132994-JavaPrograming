package app2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App2 {
  public static void main(String[] args) throws IOException {
    // Tạo chuỗi định vị tài nguyên mạng
    URL url = new URL("https://ntu.edu.vn/default.aspx");

    URLConnection connection = url.openConnection();


    InputStream in = connection.getInputStream();

    // X
    InputStreamReader ir = new InputStreamReader(in);
    BufferedReader bufRead = new BufferedReader(ir);
    String line;
    while (true) {
      line = bufRead.readLine();
      if (line == null) {
        break;
      }
      System.out.println(line);
    }
  }
}
