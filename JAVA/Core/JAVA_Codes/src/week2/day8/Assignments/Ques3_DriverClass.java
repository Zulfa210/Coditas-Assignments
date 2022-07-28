package week2.day8.Assignments;

import java.util.Random;
import java.util.Scanner;

abstract class Shape{
    abstract void area();
}

class Circle extends Shape{

    @Override
    void area() {

        float area, radius;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Radius: ");
        radius = scanner.nextInt();
        area = (float)Math.PI * radius * radius;

        System.out.println("Area of Circle is: " + area);
    }
}

class Square extends Shape{

    int side_length;
    float area;
    @Override
    void area() {

        int side;
        float area;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length of side:");
        side = scanner.nextInt();

        area = side * side;
        System.out.println("Area of Square is "+ area);

    }
}
class Cylinder extends Circle{
    void area() {
        float area, radius, height;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Radius: ");
        radius = scanner.nextInt();
        System.out.println("Enter Height: ");
        height = scanner.nextInt();
        area = 2 * (float)Math.PI * radius * height;

        System.out.println("Area of Cylinder is: " + area);

    }
}

class Rectangle extends Square{
    void area() {

        int length, breadth;
        float area1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length:");
        length = scanner.nextInt();
        System.out.println("Enter Breadth: ");
        breadth = scanner.nextInt();
        area1 = length * breadth;
        System.out.println("Area of Rectangle is "+ area1);


    }
}

public class Ques3_DriverClass {
    public static void main(String[] args) {
        Shape shape[] = new Shape[5];
        Random randomVariable = new Random();

        for(int i = 0; i < 5; i++){
            int type = randomVariable.nextInt(4);

            switch (type){
                case 0:
                    shape[i] = new Circle();
                    break;

                case 1:
                    shape[i] = new Cylinder();
                    break;

                case 2:
                    shape[i] = new Square();
                    break;
                case 3:
                    shape[i] = new Rectangle();
                    break;
            }
        }

        for(int i = 0; i < shape.length; i++){

                System.out.println("------------------------------------------");
                System.out.println("Object " + (i+1) + ": ");
                shape[i].area();
        }


    }
}

//output:
//------------------------------------------
//Object 1:
//Enter length:
//3
//Enter Breadth:
//5
//Area of Rectangle is 15.0
//------------------------------------------
//Object 2:
//Enter Radius:
//22
//Area of Circle is: 1520.531
//------------------------------------------
//Object 3:
//Enter length of side:
//11
//Area of Square is 121.0
//------------------------------------------
//Object 4:
//Enter length:
//11
//Enter Breadth:
//22
//Area of Rectangle is 242.0
//------------------------------------------
//Object 5:
//Enter Radius:
//33
//Enter Height:
//33
//Area of Cylinder is: 6842.389
//
//Process finished with exit code 0