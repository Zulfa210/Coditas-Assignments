/**
 * @author Zulfa Attar
 */
public class Circle {
    float radius;
    String name;
    Point center;
    float area;
//getter, setter, toString, display
    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", name='" + name + '\'' +
                '}';
    }

    public void display(){
        System.out.println("Radius is: " + getRadius());
        System.out.println("Center is\n X co-odinate: " + getCenter().getX() + "\nY co-ordinate: " + getCenter().getY());
    }
}
