package week2.day9;
//1)CREATE A CLASS NAMED SHAPE, WHICH CONTAINS ONLY SINGLE
//METHOD,calculateArea0. THIS METHOD SHOULD HAVE "N" NUMBER OF
//PARAMETERS FOR DIFFERENT SHAPES LIKE FOR|
//CIRCLE,RECTANGLE, TRIANGLE

import java.util.Scanner;

class Shape{
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
                }
                else if(shapeType == 2){
                        int base = sides[0];
                        int height = sides[1];
                        float area = 0.5f * base * height;
                }

        }
}

public class Ques1_DriverClass {


        public static void main(String[] args) {
                Shape shape = new Shape();
                System.out.println("Enter values to calculate area: ");
                Scanner scanner = new Scanner(System.in);
                shape.calculateArea(scanner.nextInt());

                shape.calculateArea(scanner.nextInt(), scanner.nextInt());

        }
}
