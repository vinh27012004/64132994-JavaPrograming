package ntu.vinh.finalprojectjava.models;

import java.time.LocalDate;

public class Transaction {
  private int id;
  private int categoryId;
  private double amount;
  private LocalDate date;
  private String description;
  private String categoryName;

  // Constructor
  public Transaction(int id, int categoryId, double amount, LocalDate date, String description, String categoryName) {
    this.id = id;
    this.categoryId = categoryId;
    this.amount = amount;
    this.date = date;
    this.description = description;
    this.categoryName = categoryName;
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

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}