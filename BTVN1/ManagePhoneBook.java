public class ManagePhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.insertPhone("Nguyen Van A", "0123456789");
        phoneBook.insertPhone("Nguyen Van B", "0779776153");
        phoneBook.insertPhone("Nguyen Van C", "0905355693");
        phoneBook.insertPhone("Nguyen Van D", "0123456789");

        phoneBook.sort();

        phoneBook.searchPhone("Nguyen Van A");

        phoneBook.updatePhone("Nguyen Van A", "0935681602");
        System.out.println("Danh sách sau khi cập nhật: ");
        for(User1 user : phoneBook.phoneList){
            System.out.println(user.getName() + " : " + user.getPhone());
        }
        System.out.println("Danh sách sau khi xóa: ");
        phoneBook.removePhone("Nguyen Van A");
        for (User1 user : phoneBook.phoneList){
            System.out.println(user.getName() + " : " + user.getPhone());
        }
    }

}
