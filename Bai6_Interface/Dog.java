public class Dog implements Ianimal {
    private boolean gender;
    private String category;


    // Constructor
    public Dog(String category, boolean gender) {
        this.category = category;
        this.gender = gender;
    }

    public void sound() {
        System.out.println("Gau gau");
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dog{");
        sb.append("gender=").append(gender);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }

}
