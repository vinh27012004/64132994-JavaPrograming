package ntu.vinh.finalprojectjava.services_BLL;

import ntu.vinh.finalprojectjava.repositories_DAL.TransactionDAL;

public class TransactionBLL {
  private final TransactionDAL transactionDAL = new TransactionDAL();

  public void saveTransaction(String type, double amount, String category, String date, String description) {
    // Thực hiện các kiểm tra nghiệp vụ trước khi lưu
    if (amount <= 0) {
      throw new IllegalArgumentException("Số tiền phải lớn hơn 0");
    }
    // Gọi DAL để thêm giao dịch
    transactionDAL.addTransaction(type, amount, category, date, description);
  }
}