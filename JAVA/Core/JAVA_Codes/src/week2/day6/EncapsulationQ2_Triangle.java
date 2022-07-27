package week2.day6;
//Q2)Calculate Area of Rectangle. (Without using constructors-use Encapsulation).
class areaOfTriangle{

    private static double length;
    private static double breadth;
    private static double area;

    public static double getLength() {
        return length;
    }

    public static void setLength(double length) {
        areaOfTriangle.length = length;
    }

    public static double getBreadth() {
        return breadth;
    }

    public static void setBreadth(double breadth) {
        areaOfTriangle.breadth = breadth;
    }

    public static double getArea() {
        area = length * breadth;
        return area;
    }
    public static void setArea(double area){
        areaOfTriangle.area = area;
    }

}

public class EncapsulationQ2_Triangle {


    public static void main(String[] args) {
        areaOfTriangle triangle1  = new areaOfTriangle();
        triangle1.setLength(12.5);
        triangle1.setBreadth(10.5);

        System.out.println("Area of Triangle is  " + triangle1.getArea());
    }

}

//output
//Area of Triangle is  131.25