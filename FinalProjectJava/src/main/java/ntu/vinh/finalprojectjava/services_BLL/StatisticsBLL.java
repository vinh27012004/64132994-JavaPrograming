package ntu.vinh.finalprojectjava.services_BLL;

import ntu.vinh.finalprojectjava.DAL.StatisticsDAL;
import ntu.vinh.finalprojectjava.models.Statistic;

import java.sql.SQLException;
import java.util.List;

public class StatisticsBLL {
  private final StatisticsDAL statisticsDAL;

  public StatisticsBLL() throws SQLException {
    this.statisticsDAL = new StatisticsDAL();
  }

  public List<String> getCategories() throws SQLException {
    return statisticsDAL.getCategories();
  }

  public List<Statistic> getStatistics(String category, String month) throws SQLException {
    return statisticsDAL.getStatistics(category, month);
  }
}