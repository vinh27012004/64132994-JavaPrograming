public class Cat implements Ianimal {
    private boolean gender;
    private String category;

    public void sound() {
        System.out.println("Meo meo");
    }

    public Cat(boolean gender, String category) {
        this.gender = gender;
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cat{");
        sb.append("gender=").append(gender);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
