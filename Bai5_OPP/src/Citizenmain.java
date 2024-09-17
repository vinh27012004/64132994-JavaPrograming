public class Citizenmain {
    public static void main(String[] args) {
        Citizen citizen = new Citizen("123456789", "Nguyen Van A", (short) 1999, "Nam", "Viet Nam");
        System.out.println(citizen.toString());
        Citizen citizen1 = new Citizen("123456789", "Nguyen Van B", (short) 1999, "Nam", "Viet Nam");
        System.out.println(citizen1.toString());
    }
}