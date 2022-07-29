package week2.day9;
//1)CREATE A CLASS NAMED SHAPE, WHICH CONTAINS ONLY SINGLE
//METHOD,calculateArea0. THIS METHOD SHOULD HAVE "N" NUMBER OF
//PARAMETERS FOR DIFFERENT SHAPES LIKE FOR|
//CIRCLE,RECTANGLE, TRIANGLE

import java.util.Scanner;

class Shape{

        //overloading calculateArea class one with single parameter and another with varArgs
        public void calculateArea(int radius){
                float area = (float) (Math.PI * radius * radius);
                System.out.println("Area of circle is: " + area);
        }

        public void calculateArea(int ... sides){

                System.out.println("Is it a 1. Rectangle \n 2. Triangle");
                Scanner scanner = new Scanner(System.in);

                int shapeType = scanner.nextInt();
                if(shapeType == 1) {
                        int length = sides[0];
                        int breadth = sides[1];
                        float area = length * breadth;
                        System.out.println("Area of Rectangle is " + area);
                }
                else if(shapeType == 2){
                        int base = sides[0];
                        int height = sides[1];
                        float area = 0.5f * base * height;
                        System.out.println("Area of Rectangle is " + area);
                }

        }
}

public class Ques1_DriverClass {


        public static void main(String[] args) {
                Shape shape = new Shape();
                System.out.println("Enter no. of arguments: ");
                Scanner scanner = new Scanner(System.in);
                int attributes = scanner.nextInt();
                if(attributes ==1) {
                        System.out.println("Enter radius of cicle");
                        shape.calculateArea(scanner.nextInt());
                }
                else {
                        System.out.println("Enter the values: ");
                        shape.calculateArea(scanner.nextInt(), scanner.nextInt());
                }

        }
}

//output
//Enter no. of arguments:
//1
//Enter radius of cicle
//21
//Area of circle is: 1385.4424
//
//
//Enter no. of arguments:
//2
//Enter the values:
//12
//15
//Is it a 1. Rectangle
// 2. Triangle
//1
//Area of Rectangle is 180.0
//
