/**
 * @author Zulfa Attar
 */
public class Shape {

    Circle c;
    Triangle t;

    public Triangle getT() {
        return t;
    }

    public void setT(Triangle t) {
        this.t = t;
    }

    public Circle getC() {
        return c;
    }

    public void setC(Circle c) {
        this.c = c;
    }

    public void display(){
        c.display();
        System.out.println(t.toString());
    }
}
