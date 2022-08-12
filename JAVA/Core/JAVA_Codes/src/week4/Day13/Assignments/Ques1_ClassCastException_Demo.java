package week4.Day13.Assignments;

/**Q.1) Write a code for "ClassCastException" and handle it using Exception Handling Mechanism
 *=>try,catch, finally
 *
 * @author Zulfa Attar-Coditas
 *
 */
class Shape{
    float area;
}
class Triangle extends Shape{
    int base;
    int height;
    float area;


    public void setBase(int base) {
        this.base = base;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getArea() {
        return (0.5f * base * height);
    }

}
public class Ques1_ClassCastException_Demo {
    public static void main(String[] args) {

        try {
            //creating parent object
            Shape shape = new Shape();

            //type casting shape object to Triangle object
            //this will give Class cast Exception, because we are typecasting
            //parent type to its child type
            Triangle triangle = (Triangle) shape;
        }
        catch (Exception e){
            System.out.println("========================================================");
            System.out.println("Exception class: " + e.getClass());
            System.out.println("Message: " + e.getMessage());
        }
        finally {
            //this block gets executed even though exception occurs
            System.out.println("===============================================");
            System.out.println("Inside Finally block, after exception occurred");

        }
    }
}
/*
Output:
========================================================
Exception class: class java.lang.ClassCastException
Message: week4.Day13.Assignments.Shape cannot be cast to week4.Day13.Assignments.Triangle
===============================================
Inside Finally block, after exception occurred

Process finished with exit code 0
 */

