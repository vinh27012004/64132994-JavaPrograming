package ntu.vinh.finalprojectjava.models;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
  private final List<Transaction> transactions = new ArrayList<>();

  public List<Transaction> getAllTransactions() {
    return new ArrayList<>(transactions);
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }
}
