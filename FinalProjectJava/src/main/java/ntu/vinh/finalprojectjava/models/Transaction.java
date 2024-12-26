package ntu.vinh.finalprojectjava.models;

public class Transaction {
  private int id;
  private int categoryId;
  private double amount;
  private String date;
  private String description;

  public Transaction(int id, int categoryId, double amount, String date, String description) {
    this.id = id;
    this.categoryId = categoryId;
    this.amount = amount;
    this.date = date;
    this.description = description;
  }

  // Getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}