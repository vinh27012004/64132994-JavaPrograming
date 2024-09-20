import java.util.ArrayList;

public class PhoneBook extends Phone {

    ArrayList<User1> phoneList = new ArrayList<>();

    public void insertPhone(String name, String phone){
        for (User1 user : phoneList){
            if (user.getName().equals(name)){
                if (!user.getPhone().contains(phone)){
                    user.setPhone(user.getPhone() + " : " + phone);
                    return;
                }
                return;
            }
        }
        phoneList.add(new User1(name, phone));
        
    }
    // Xóa người dùng cùng các số điện thoại của chủ sở hữu có tên (name) tương ứng khỏi PhoneList
    public void removePhone(String name){
        for (User1 user : phoneList){
            if(user.getName().equals(name)){
                phoneList.remove(user);
                return;
            }    
        }
    }
    public void updatePhone(String name, String newPhone) {
        for (User1 user : phoneList) {
            if (user.getName().equals(name)) {
                // Thêm số điện thoại mới nếu nó chưa tồn tại
                if (!user.getPhone().contains(newPhone)) {
                    user.setPhone(user.getPhone() + " : " + newPhone);
                    System.out.println("Đã thêm số điện thoại mới cho " + name);
                } else {
                    System.out.println("Số điện thoại đã tồn tại cho " + name);
                }
                return;
            }
        }
        System.out.println("Không tìm thấy người dùng với tên: " + name);
    }
    public void searchPhone(String name){
        for (User1 user : phoneList){
            if (user.getName().equals(name)){
                System.out.println(user.getPhone());
                return;
            }
        }
    }
    public void sort(){
        phoneList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (User1 user : phoneList){
            System.out.println(user.getName() + " : " + user.getPhone());
        }
    }
}
