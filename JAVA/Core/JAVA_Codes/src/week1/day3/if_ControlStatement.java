package week1.day3;

class Calculator{
    int ans;
    public void switch_demo(){
        char operation = '+';
        int num1= 10, num2= 20;

        switch(operation)
        {
            case '+':
                ans = num1 + num2;
                System.out.println("Addition is "+ ans);
                break;

            case '-':
                ans = num1 - num2;
                System.out.println("Subtraction is "+ ans);
                break;

            case '*':
                ans = num1 * num2;
                System.out.println("Multiplication is "+ ans);
                break;

            case '/':
                ans = num1 / num2;
                System.out.println("Division is "+ ans);
                break;

            default:
                System.out.println("Select any of the operation: + - * / ");

        }
    }
}



public class if_ControlStatement {

    public static void main(String args[]){

        Calculator calculatorObj = new Calculator();

        calculatorObj.switch_demo();
    }
}
