package week3.day11.ClassPracticals;

public interface Animal {
    void sleep();
    void eat();

}
class Main {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            @Override
            public void sleep() {
                System.out.println("Dog is sleeping");
            }

            @Override
            public void eat() {
                System.out.println("Dog is eating");
            }
        };

        dog.eat();
        dog.sleep();
    }
}

