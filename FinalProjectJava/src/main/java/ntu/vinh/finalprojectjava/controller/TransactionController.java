package ntu.vinh.finalprojectjava.controller;

import ntu.vinh.finalprojectjava.services_BLL.TransactionBLL;

public class TransactionController {
  private final TransactionBLL transactionBLL = new TransactionBLL();

  public void handleAddTransaction(String type, double amount, String category, String date, String description) {
    try {
      transactionBLL.saveTransaction(type, amount, category, date, description);
      System.out.println("Giao dịch đã được thêm thành công!");
    } catch (Exception e) {
      System.out.println("Lỗi: " + e.getMessage());
    }
  }
}