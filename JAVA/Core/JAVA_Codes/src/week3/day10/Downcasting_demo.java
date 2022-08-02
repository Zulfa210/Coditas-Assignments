package week3.day10;

class Shape{

}
class Circle extends Shape{
    static void show(Shape s){
        System.out.println("This is child class");
        if (s instanceof Circle){
            Circle c = (Circle) s;
            System.out.println("Down casting Done");
        }
    }
}

public class Downcasting_demo {
    public static void main(String[] args) {
        Shape s = new Circle();
       /// Circle c = new Circle();

       // Circle circle ;
                //= (Circle) new Shape();
        Circle.show(s);
    }
}
