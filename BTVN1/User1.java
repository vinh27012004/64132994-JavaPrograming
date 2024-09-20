public class User1{
    private String name;
    private String phone;

    public User1(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
