package ntu.vinh.finalprojectjava.services_BLL;

import ntu.vinh.finalprojectjava.models.TransactionDAO;
import ntu.vinh.finalprojectjava.models.Transaction;
import java.util.List;

public class TransactionService {
  private final TransactionDAO transactionDAO;

  public TransactionService() {
    this.transactionDAO = new TransactionDAO();
  }

  public List<Transaction> getTransactions() {
    return transactionDAO.getAllTransactions();
  }

  public void addTransaction(Transaction transaction) {
    transactionDAO.addTransaction(transaction);
  }
}

