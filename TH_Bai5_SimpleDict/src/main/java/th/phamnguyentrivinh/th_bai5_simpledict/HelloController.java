package th.phamnguyentrivinh.th_bai5_simpledict;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;

public class HelloController {
  @FXML
  private TextField tuField; // Thay đổi thành TextField để nhập từ

  @FXML
  private TextField phienAm;

  @FXML
  private TextField nghia;

  @FXML
  private Button btnTraTu;

  @FXML
  private Button btnThem;

  private HashMap<String, String[]> dict = new HashMap<>();
  private ArrayList<String> list = new ArrayList<>();


  public void initialize() {
    dict.put("hello", new String[]{"həˈloʊ", "Xin chào"});
    dict.put("world", new String[]{"wɜːrld", "Thế giới"});

    btnTraTu.setOnAction(actionEvent -> timTu());
    btnThem.setOnAction(actionEvent -> themTu());
  }

  public void timTu() {
    String tu = tuField.getText().trim().toLowerCase();
    if (dict.containsKey(tu)) {
      String[] details = dict.get(tu);
      phienAm.setText(details[0]);
      nghia.setText(details[1]);
    } else {
      phienAm.setText("Không tìm thấy phiên âm từ này.");
      nghia.setText("Không tìm thấy nghĩa từ này");
    }
  }

  public void themTu() {
    String tu = tuField.getText().trim().toLowerCase();
    String[] details = new String[]{phienAm.getText(), nghia.getText()};

    if (!tu.isEmpty() && !details[0].isEmpty() && !details[1].isEmpty()) {
      dict.put(tu, details);
      list.add(tu); // Giả sử `list` là ObservableList để hiển thị danh sách từ
      tuField.setText("");
      phienAm.setText("");
      nghia.setText("");

      // Hiển thị thông báo thành công
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Thêm từ thành công");
      alert.setHeaderText(null);
      alert.setContentText("Từ \"" + tu + "\" đã được thêm vào từ điển!");
      alert.showAndWait();
    } else {
      // Hiển thị thông báo lỗi nếu nhập thiếu thông tin
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Lỗi");
      alert.setHeaderText("Không thể thêm từ!");
      alert.setContentText("Vui lòng điền đầy đủ từ, phiên âm và nghĩa.");
      alert.showAndWait();

    }
  }
}
