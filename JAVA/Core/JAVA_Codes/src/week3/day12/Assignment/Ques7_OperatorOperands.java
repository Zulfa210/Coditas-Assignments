package week3.day12.Assignment;
//7)Separate the tokens(operands and operators) from below statement:
//3+ (20%2) (20/2)
//Case 1)Print separated tokens
//Case 2)Print Operators and Operand separately
import java.util.StringTokenizer;

class OperatorOperands{
    public static void checkTokens(String expression){

        System.out.println("\nSeparated Tokens: ");
        StringTokenizer tokenExpression1 = new StringTokenizer(expression, "+,(,),/,*,%");
        while(tokenExpression1.hasMoreTokens())
           System.out.print(tokenExpression1.nextToken() + " ");

        System.out.println("\nSeparated operands:");
        StringTokenizer tokenExpression2 = new StringTokenizer(expression, "+()/*%");
        while(tokenExpression2.hasMoreTokens())
            System.out.print(tokenExpression2.nextToken() + " ");

        System.out.println("\nSeparated Operators: ");
        StringTokenizer tokenExpression3 = new StringTokenizer(expression, "1234567890");
        while(tokenExpression3.hasMoreTokens())
            System.out.print(tokenExpression3.nextToken() + " ");


    }
}

public class Ques7_OperatorOperands {

    public static void main(String[] args) {
        String expression = "3+(20%2)*(20/2)";
        OperatorOperands.checkTokens(expression);
    }

}

//ouput:
//
//Separated Tokens:
//3 20 2 20 2
//Separated operands:
//3 20 2 20 2
//Separated Operators:
//+( % )*( / )
//Process finished with exit code 0