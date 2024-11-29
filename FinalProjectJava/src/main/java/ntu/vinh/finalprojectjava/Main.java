package ntu.vinh.finalprojectjava;

import ntu.vinh.finalprojectjava.repositories_DAL.DatabaseConnection;

public class Main {
  public static void main(String[] args){
    DatabaseConnection.getConnection();
  }
}
