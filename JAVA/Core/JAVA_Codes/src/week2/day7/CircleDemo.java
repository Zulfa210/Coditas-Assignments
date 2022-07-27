package week2.day7;

//Parent
class Shape{

    public void area(){
        System.out.println("This is Shape area()");
    }

}

//child
class Circle extends Shape{
    private double area;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    int radius;

    public void area(){
        setRadius(45);
        area  = Math.PI * radius * radius;
        System.out.println("Area of Circle is " + area);
    }


}

public class CircleDemo {
    public static void main(String[] args) {
        //parent class object
        Shape shape = new Shape();
        shape.area();

        //child class object with parent reference
        Shape circle  =new Circle();
        circle.area();

        //particular child object
        Circle circle1 = new Circle();
        circle1.area();
    }
}
