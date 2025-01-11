package ntu.vinh.finalprojectjava.models;

public class Statistic {
  private String categoryName;
  private String month;
  private double totalAmount;

  public Statistic(String categoryName, String month, double totalAmount) {
    this.categoryName = categoryName;
    this.month = month;
    this.totalAmount = totalAmount;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }
}