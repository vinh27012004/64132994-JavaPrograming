package ntu.vinh.finalprojectjava.repositories_DAL;

import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/quanlychitieu";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "";

  public static Connection getConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
      System.out.println("Connected to the database");
    } catch (Exception e) {
      System.out.println("Error connecting to the database");
      e.printStackTrace();
    }
    return connection;
  }





}
