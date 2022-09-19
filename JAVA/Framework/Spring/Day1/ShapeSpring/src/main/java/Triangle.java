/**
 * @author Zulfa Attar
 */
public class Triangle {
    float height, base;
    Point p1, p2, p3;
    String name;

    @Override
    public String toString() {
        return "Triangle{" +
                "height=" + height +
                ", base=" + base +
                ", p1=" + p1.getX() + " & "+ p1.getY() +
                ", p2=" + p2.getX() + " & " + p2.getY() +
                ", p3=" + p3.getX() + " & " + p3.getY() +
                ", name='" + name + '\'' +
                '}';
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
