package org.example.cau2;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainController {
  @FXML private TableView<HocSinh> hocSinhTable;
  @FXML private TableColumn<HocSinh, Integer> idColumn;
  @FXML private TableColumn<HocSinh, String> hoTenColumn;
  @FXML private TableColumn<HocSinh, String> ngaySinhColumn;
  @FXML private TableColumn<HocSinh, String> lopColumn;
  @FXML private TableColumn<HocSinh, String> diaChiColumn;

  private Connection connectDB() throws SQLException {
    // Kết nối cơ sở dữ liệu
    String url = "jdbc:mysql://localhost:3306/QuanLyHocSinh";
    String user = "root";
    String password = ""; // Mật khẩu của MySQL
    return DriverManager.getConnection(url, user, password);
  }

  @FXML
  public void initialize() {
    idColumn.setCellValueFactory(new PropertyValueFactory<>("hocSinhId"));
    hoTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    ngaySinhColumn.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
    lopColumn.setCellValueFactory(new PropertyValueFactory<>("lop"));
    diaChiColumn.setCellValueFactory(new PropertyValueFactory<>("diaChi"));

    loadHocSinhData();
  }

  private void loadHocSinhData() {
    // Nạp dữ liệu từ cơ sở dữ liệu vào bảng

  }

  public void handleAdd() {
    // Mở form thêm học sinh
  }

  public void handleDelete() {
    // Xóa học sinh được chọn
  }

  public void handleEdit() {
    // Mở form sửa thông tin học sinh
  }
}