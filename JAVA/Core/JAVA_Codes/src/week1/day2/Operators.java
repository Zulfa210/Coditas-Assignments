package week1.day2;

public class Operators {

    public static void main(String[] args) {

        Operators_Class Operators_Object = new Operators_Class();
        Operators_Object.arithmatic_Operator();
        Operators_Object.assignment_Operator();
        Operators_Object.logical_operators();
        Operators_Object.relational_Operators();
        Operators_Object.unary_operators();
        Operators_Object.ternary_operator();

    }




}

class Operators_Class {
    public void  arithmatic_Operator( ){
        int num1 =10, num2 =2;
        System.out.println("Addition"+ (num1 + num2));
        System.out.println("Subtraction"+ (num1 - num2));
        System.out.println("multiplication"+ (num1 * num2));
        System.out.println("division"+ (num1 / num2));

    }
    public void assignment_Operator(){
        // create variables
        int a = 4;
        int var;

        // assign value using =
        var = a;
        System.out.println("var using =: " + var);

        // assign value using =+
        var += a;
        System.out.println("var using +=: " + var);

        // assign value using =*
        var *= a;
        System.out.println("var using *=: " + var);
    }
    public void relational_Operators(){
        // create variables
        int a = 7, b = 11;

        // value of a and b
        System.out.println("a is " + a + " and b is " + b);

        // == operator
        System.out.println(a == b);  // false

        // != operator
        System.out.println(a != b);  // true

        // > operator
        System.out.println(a > b);  // false

        // < operator
        System.out.println(a < b);  // true

        // >= operator
        System.out.println(a >= b);  // false

        // <= operator
        System.out.println(a <= b);  // true
    }
    public void logical_operators(){
        // && operator
        System.out.println((5 > 3) && (8 > 5));  // true
        System.out.println((5 > 3) && (8 < 5));  // false

        // || operator
        System.out.println((5 < 3) || (8 > 5));  // true
        System.out.println((5 > 3) || (8 < 5));  // true
        System.out.println((5 < 3) || (8 < 5));  // false

        // ! operator
        System.out.println(!(5 == 3));  // true
        System.out.println(!(5 > 3));  // false
    }
    public void unary_operators(){
        // declare variables
        int a = 12, b = 12;
        int result1, result2;

        // original value
        System.out.println("Value of a: " + a);

        // increment operator
        result1 = ++a;
        System.out.println("After increment: " + result1);

        System.out.println("Value of b: " + b);

        // decrement operator
        result2 = --b;
        System.out.println("After decrement: " + result2);
    }
    public void ternary_operator(){
        int februaryDays = 29;
        String result;

        // ternary operator
        result = (februaryDays == 28) ? "Not a leap year" : "Leap year";
        System.out.println(result);
    }


}
