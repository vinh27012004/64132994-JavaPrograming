public class Apps {
    public static void main(String[] args) {
        Dog dog = new Dog("Gau gau", true); 
        Cat cat = new Cat(true, "Meo meo");
        System.out.println(dog.toString());
        System.out.println(cat.toString());

        Ianimal d1 = new Dog("Gau gau", true);
        Ianimal c1 = new Cat(true, "Meo meo"); 
        System.out.println(d1.toString());
        System.out.println(c1.toString());
    }
}


// interface Ianimal là gì với class cat và dog
// interface Ianimal là interface chứa phương thức sound() được implement bởi các class Dog và Cat
// class Dog và Cat implement interface Ianimal để thực hiện phương thức sound() của interface Ianimal

