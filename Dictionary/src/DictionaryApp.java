import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class DictionaryApp extends JFrame {
  private final JTextField inputField;
  private final JLabel outputLabel;
  private final Map<String, String> dictionary = new HashMap<>();

  public DictionaryApp() {
    // Khởi tạo giao diện
    setTitle("Từ điển Anh-Việt");
    setSize(300, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

    // Thêm các thành phần vào giao diện
    inputField = new JTextField(20);
    inputField.setBounds(20, 20, 200, 25);
    add(inputField);

    JButton searchButton = new JButton("Tìm");
    searchButton.setBounds(230, 20, 50, 25);
    searchButton.addActionListener(e -> searchWord());
    add(searchButton);

    outputLabel = new JLabel();
    outputLabel.setBounds(20, 50, 250, 25);
    add(outputLabel);

    // Khởi tạo từ điển (bạn có thể đọc từ file ở đây)
    dictionary.put("hello", "xin chào");
    dictionary.put("world", "thế giới");

    setVisible(true);
  }

  private void searchWord() {
    String englishWord = inputField.getText();
    String vietnameseWord = dictionary.get(englishWord);
    if (vietnameseWord != null) {
      outputLabel.setText(vietnameseWord);
    } else {
      outputLabel.setText("Từ không tìm thấy");
    }
  }

  public static void main(String[] args) {
    new DictionaryApp();
  }
}