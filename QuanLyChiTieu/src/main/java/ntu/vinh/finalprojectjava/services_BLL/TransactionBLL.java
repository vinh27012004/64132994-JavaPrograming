package ntu.vinh.finalprojectjava.services_BLL;

import ntu.vinh.finalprojectjava.DAL.TransactionDAL;
import ntu.vinh.finalprojectjava.models.Transaction;

import java.sql.SQLException;
import java.util.List;

public class TransactionBLL {
  private final TransactionDAL transactionDAO;

  public TransactionBLL() throws SQLException {
    this.transactionDAO = new TransactionDAL();
  }

  public void addTransaction(Transaction transaction) throws SQLException {
    transactionDAO.addTransaction(transaction);
  }

  public List<Transaction> getTransactions() throws SQLException {
    return transactionDAO.getTransactions();
  }

  public void deleteTransaction(Transaction transaction) throws SQLException {
    transactionDAO.deleteTransaction(transaction.getId());
  }
}